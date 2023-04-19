package io.craftgate.request;

import io.craftgate.model.WalletTransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class SearchWalletTransactionsRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
    private Set<WalletTransactionType> walletTransactionTypes;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
}
