package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loyalty {
    private LoyaltyType type;
    private Reward reward;
    private String message;
    private LoyaltyParams loyaltyParams;
    private LoyaltyData loyaltyData;
}
