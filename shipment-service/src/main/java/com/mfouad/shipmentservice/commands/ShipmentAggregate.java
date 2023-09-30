package com.mfouad.shipmentservice.commands;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import com.mfouad.commonservice.commands.OrderShipedEvent;
import com.mfouad.commonservice.commands.ShipOrderCommand;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aggregate
@NoArgsConstructor
@Slf4j
public class ShipmentAggregate {

    String orderId;

    @AggregateIdentifier
    String shipmentId;

    String status;

   

    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand command){
        log.info("-----ShipmentAggregate : recive  ShipOrder command for orderid {}",command.getOrderId());
        this.orderId =command.getOrderId();
        this.shipmentId=command.getShipmentId();

AggregateLifecycle.apply(OrderShipedEvent.builder().orderId(command.getOrderId())
.shipmentId(command.getShipmentId())
.status("compeleted")
.build()

);
    }

    @EventSourcingHandler
    private void on(OrderShipedEvent event){
this.orderId=event.getOrderId();
this.shipmentId = event.getShipmentId();
this.status =event.getStatus();
    }
    
}
