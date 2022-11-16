package io.craftgate.response.dto;

import io.craftgate.model.WalletTransactionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletTransaction {

    private Long id;
    private WalletTransactionType walletTransactionType;
    private BigDecimal amount;
    private Long walletId;
}
