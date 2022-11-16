package io.craftgate.response;

import io.craftgate.response.dto.WalletTransaction;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransferDepositPaymentResponse {

    private BigDecimal price;
    private String currency;
    private String conversationId;
    private Long buyerMemberId;
    private WalletTransaction walletTransaction;
}
