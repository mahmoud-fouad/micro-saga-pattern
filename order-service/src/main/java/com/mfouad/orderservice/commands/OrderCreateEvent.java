package com.mfouad.orderservice.commands;

import com.mfouad.orderservice.OrderJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderCreateEvent {

    private String orderId;
    private String orderStatus;
    OrderJson payload;
    
}
