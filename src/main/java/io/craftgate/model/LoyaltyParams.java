package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoyaltyParams {
    private Integer postponingPaymentCount;
}
