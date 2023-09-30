package com.mfouad.notificationservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.mfouad.commonservice.commands.NotifyUserCommand;
import com.mfouad.commonservice.commands.UserNotifiedEvent;

import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
public class NotificationAggregate {

    @AggregateIdentifier
    String orderId;
    String userEmail;
    String status;


    @CommandHandler
    public NotificationAggregate(NotifyUserCommand command){
        log.info("-----NotificationAggregate : recive  ShipOrder command for orderid {}",command.getOrderId());
        this.orderId=command.getOrderId();
        this.userEmail=command.getUserEmail();
        // notify user

        AggregateLifecycle.apply(new UserNotifiedEvent(userEmail, orderId,"notified") );
    }

    @EventSourcingHandler
    private void on (UserNotifiedEvent event){
    this.orderId=event.getOrderId();
    this.userEmail=event.getUserEmail();
    this.status=event.getStatus();
    }
    
}
