package com.mfouad.paymentservice.commands;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.mfouad.commonservice.commands.PaymentProcessEvent;
import com.mfouad.commonservice.commands.ValidatePaymentCommand;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aggregate
@NoArgsConstructor
@Slf4j
public class PaymentAggregate {

     @AggregateIdentifier
     private String paymentId;
     private String orderId;
    private String paymentStatus;

    @CommandHandler
    public PaymentAggregate(ValidatePaymentCommand command){
log.info("-----PaymentAggregate : recive  payment command for orderid {} and paymentid {}",command.getOrderId(),command.getPaymentId());

        this.orderId=command.getOrderId();
        this.paymentId=command.getPaymentId();
        //validate payment details if valid puplish the command

        boolean validPayment =true;
        if(!validPayment){

        }
        PaymentProcessEvent paymentProcessEvent = new PaymentProcessEvent(command.getOrderId(), command.getPaymentId());
        AggregateLifecycle.apply(paymentProcessEvent);

        log.info("-----PaymentAgg apply paymentProcessEventf for orderid {} and paymentid {}",command.getOrderId(),command.getPaymentId());



    }

    @EventSourcingHandler
    public void on( PaymentProcessEvent paymentProcessEvent){
        this.orderId=paymentProcessEvent.getOrderId();
        this.paymentId = paymentProcessEvent.getPaymentId();
    }
    
}
