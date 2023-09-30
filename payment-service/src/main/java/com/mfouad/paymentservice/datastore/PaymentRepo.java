package com.mfouad.paymentservice.datastore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentBean,String>{
    
}
