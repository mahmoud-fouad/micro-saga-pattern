package com.mfouad.paymentservice.commands;

import java.time.LocalDateTime;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.commonservice.commands.PaymentProcessEvent;
import com.mfouad.paymentservice.datastore.PaymentBean;
import com.mfouad.paymentservice.datastore.PaymentRepo;

@Component
public class PaymentProcessEventHandler {

 @Autowired
 PaymentRepo repo;
 
 @EventHandler
 public void on(PaymentProcessEvent event){

    repo.save(new PaymentBean(event.getPaymentId()
    , event.getOrderId()
    ,"completed",LocalDateTime.now()));

 }
    
}
