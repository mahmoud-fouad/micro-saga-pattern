package com.mfouad.shipmentservice.dataStore;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderShipment {

    @Id
    private String shipmentId;
    private String orderId;
    private String status;
    
    
}
