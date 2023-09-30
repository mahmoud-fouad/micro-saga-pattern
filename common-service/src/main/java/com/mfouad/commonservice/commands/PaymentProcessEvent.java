package com.mfouad.commonservice.commands;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessEvent implements Serializable{

    private String orderId;
    private String paymentId;
    

}
