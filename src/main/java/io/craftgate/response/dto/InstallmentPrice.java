package io.craftgate.response.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InstallmentPrice {

    private String posAlias;
    private Integer installmentNumber;
    private BigDecimal installmentPrice;
    private BigDecimal bankCommissionRate;
    private BigDecimal merchantCommissionRate;
    private BigDecimal totalPrice;
    private String installmentLabel;
    private Boolean loyaltySupported;
}
