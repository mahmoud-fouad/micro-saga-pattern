package com.mfouad.paymentservice.datastore;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentBean {

    @Id
    private String paymentId;
     private String orderId;
    private String paymentStatus;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;
    
}
