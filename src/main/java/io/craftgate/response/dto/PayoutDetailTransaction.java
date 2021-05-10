package io.craftgate.response.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayoutDetailTransaction {

    private Long transactionId;
    private String transactionType;
    private BigDecimal payoutAmount;
}