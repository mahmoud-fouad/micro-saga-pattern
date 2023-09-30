package com.mfouad.commonservice.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipOrderCommand {


    private String orderId;
    @TargetAggregateIdentifier
    private String shipmentId;

}
