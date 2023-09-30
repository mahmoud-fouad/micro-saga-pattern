package com.mfouad.shipmentservice.dataStore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepo extends JpaRepository<OrderShipment,String>{
    
}
