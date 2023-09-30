package com.mfouad.commonservice.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDetails {

    private  String name;
    private String cardNo;
    private String validUntilMonth;
    private String validUnitYEar;
    private String cvv;
    
}
