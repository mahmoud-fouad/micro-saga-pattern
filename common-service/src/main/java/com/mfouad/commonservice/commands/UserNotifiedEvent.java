package com.mfouad.commonservice.commands;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotifiedEvent implements Serializable{

    private String userEmail;
    private String orderId;
    private String status;

    
}
