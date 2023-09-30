package com.mfouad.shipmentservice.commands;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.commonservice.commands.OrderShipedEvent;
import com.mfouad.shipmentservice.dataStore.OrderShipment;
import com.mfouad.shipmentservice.dataStore.ShipmentRepo;

@Component
public class OrderShipmentEventHandler {

@Autowired
ShipmentRepo repo;
    
     @EventHandler
 public void on(OrderShipedEvent event){

repo.save(new OrderShipment(event.getOrderId(), event.getShipmentId(), event.getStatus()));

 }
    
}
