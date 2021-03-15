package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RefundWalletTransactionToCardRequest {

    private BigDecimal refundPrice;
}