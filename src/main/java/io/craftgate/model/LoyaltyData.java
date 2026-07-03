package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LoyaltyData {

    private Integer maxPostponingPaymentCount;
    private Integer minPostponingPaymentCount;
    private LoyaltyUnitType unitType;
    private Boolean deferredPaymentEligible;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String dueDateShiftDirection;
    private BigDecimal singleTotalDueDateDayCount;
    private String code;
}
