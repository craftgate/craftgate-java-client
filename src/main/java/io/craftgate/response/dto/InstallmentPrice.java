package io.craftgate.response.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InstallmentPrice {

    private String posAlias;
    private Integer installmentNumber;
    private BigDecimal installmentPrice;
    private BigDecimal totalPrice;
}
