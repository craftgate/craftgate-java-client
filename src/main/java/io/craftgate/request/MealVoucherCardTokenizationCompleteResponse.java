package io.craftgate.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MealVoucherCardTokenizationCompleteResponse {

    private String sessionId;
    private String maskedCardNumber;
    private BigDecimal balance;
}
