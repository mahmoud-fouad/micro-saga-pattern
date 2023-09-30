package com.mfouad.orderservice.commands;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.orderservice.OrderJson;
import com.mfouad.orderservice.dataStore.OrderBean;
import com.mfouad.orderservice.dataStore.OrderRepo;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Slf4j
public class CommandsAggregate {

   

    @AggregateIdentifier
     private String orderId;
    private String orderStatus;
    OrderJson payload;



    @CommandHandler
    public CommandsAggregate(CreateOrderCommand command){
        this.payload=command.getPayload();
        this.orderStatus=command.getOrderStatus();
        this.orderId = command.getOrderId();
        /*process validation and if ok raise event */

        OrderCreateEvent event = new OrderCreateEvent();

        BeanUtils.copyProperties(command, event);
        apply(event);
        
    }

     @EventSourcingHandler 
public void on(OrderCreateEvent event) { 
    this.orderStatus = event.getOrderStatus();
    this.payload = event.getPayload();
    this.orderId = event.getOrderId();

   
    log.info("order with id {} been created {}",event.getOrderId());
}
    
}
