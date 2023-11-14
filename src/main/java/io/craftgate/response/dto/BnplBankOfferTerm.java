package io.craftgate.response.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BnplBankOfferTerm {

    private Integer term;
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private BigDecimal interestRate;
    private BigDecimal annualInterestRate;
}
