package com.mfouad.orderservice.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.mfouad.orderservice.OrderJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String orderStatus;
    OrderJson payload;

    


    
}
