package com.mfouad.orderservice.commands;

import java.util.UUID;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.orderservice.dataStore.OrderBean;
import com.mfouad.orderservice.dataStore.OrderRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderCreateEventHandler {
     @Autowired
    OrderRepo orderRepo;

     @EventHandler
    public void on(OrderCreateEvent event){
        log.info("----------in OrderCreateEventHandler: create new order  with id {}",event.getOrderId());

         OrderBean bean = new OrderBean();
    BeanUtils.copyProperties(event, bean);
    bean.setOrderId(UUID.fromString(event.getOrderId()));

    orderRepo.save(bean);


    }
    
}
