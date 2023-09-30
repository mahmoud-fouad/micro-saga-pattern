package com.mfouad.orderservice.dataStore;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderBean,UUID> {
    
}
