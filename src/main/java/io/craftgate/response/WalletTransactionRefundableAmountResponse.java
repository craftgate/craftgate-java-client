package io.craftgate.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletTransactionRefundableAmountResponse {

    private BigDecimal refundableAmount;
}