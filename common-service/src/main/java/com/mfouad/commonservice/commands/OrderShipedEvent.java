package com.mfouad.commonservice.commands;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderShipedEvent implements Serializable{

    private String orderId;
    private String shipmentId;
    private String status;
    
}
