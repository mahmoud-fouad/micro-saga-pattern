package com.mfouad.commonservice.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyUserCommand {

    @TargetAggregateIdentifier
    String orderId;
    String userEmail;
    
}
