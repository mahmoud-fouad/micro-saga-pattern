package com.mfouad.orderservice;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderJson implements Serializable{
    private String productId;
    private String userEmail;
    private String addressId;
    private int productsCount;
}
