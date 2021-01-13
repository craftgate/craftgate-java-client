package io.craftgate.response;

import io.craftgate.model.WalletTransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletTransactionResponse {

    private Long id;
    private LocalDateTime createdDate;
    private WalletTransactionType walletTransactionType;
    private BigDecimal amount;
    private Long transactionId;
    private Long walletId;

}
