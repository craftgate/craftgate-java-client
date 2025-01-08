package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoyaltyData {
    private Integer maxPostponingPaymentCount;
    private String unitType;
}
