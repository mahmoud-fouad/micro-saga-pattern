package com.mfouad.orderservice.dataStore;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderBean {


    @Id
    private UUID orderId;
    private String productId;
    private String userEmail;
    private String addressId;
    private int productsCount;
    private String orderStatus;
    
}
