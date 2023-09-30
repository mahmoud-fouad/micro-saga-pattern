package com.mfouad.orderservice.Saga;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.mfouad.commonservice.Models.CardDetails;
import com.mfouad.commonservice.commands.NotifyUserCommand;
import com.mfouad.commonservice.commands.OrderShipedEvent;
import com.mfouad.commonservice.commands.PaymentProcessEvent;
import com.mfouad.commonservice.commands.ShipOrderCommand;
import com.mfouad.commonservice.commands.UserNotifiedEvent;
import com.mfouad.commonservice.commands.ValidatePaymentCommand;
import com.mfouad.orderservice.commands.OrderCreateEvent;

import lombok.extern.slf4j.Slf4j;

@Saga
@Slf4j
public class OrderProcessingSaga {

     @Autowired
        CommandGateway commandGateway;

        @Autowired
        QueryGateway queryGateway;

        Map<String ,String> orderUsers = new HashMap<>();

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    private void handle(OrderCreateEvent event){
        log.info("start saga pattern for order id {}",event.getOrderId());

       
        orderUsers.put(event.getOrderId(), event.getPayload().getUserEmail());
        ValidatePaymentCommand validatePaymentCommand = ValidatePaymentCommand.builder()
        /*  create dummy card 
        we can take it from ui or create query to retive it from other micro service
        */
        .CardDetails(CardDetails.builder().cardNo("Card no")
        .cvv("cvv").name("card holder name")
        .validUnitYEar("2030")
        .validUntilMonth("01").build())
        .orderId(event.getOrderId())
        .paymentId(UUID.randomUUID().toString())
        
        .build();

commandGateway.sendAndWait(validatePaymentCommand);

    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(PaymentProcessEvent event){
        log.info("saga pattern for order id {} in handel payment",event.getOrderId());
        ShipOrderCommand command = new ShipOrderCommand(event.getOrderId(),UUID.randomUUID().toString());
        try{
    commandGateway.sendAndWait(command);
        }
        catch(Exception e){
            log.error("error while shipping order {} error is {}",event.getOrderId(),e.getMessage());
        }
        
    }

     @SagaEventHandler(associationProperty = "orderId")
      private void handle(OrderShipedEvent event){
        log.info("saga pattern for order id {} in handle shipment",event.getOrderId());
        NotifyUserCommand command = new NotifyUserCommand(event.getOrderId(), orderUsers.get(event.getOrderId()));
        try{
        commandGateway.sendAndWait(command);
        }
        catch(Exception e){
            log.error("error while notifing user for order {} error is {}",event.getOrderId(),e.getMessage());
        }
      }

      @EndSaga
      @SagaEventHandler(associationProperty = "orderId")
       private void handle(UserNotifiedEvent event){
        log.info("end saga pattern for order id {} in handle shipment",event.getOrderId());
       }
    
}
