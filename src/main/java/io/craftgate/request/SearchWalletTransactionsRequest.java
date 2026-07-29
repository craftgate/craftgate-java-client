package io.craftgate.request;

import io.craftgate.model.WalletTransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchWalletTransactionsRequest extends BaseRequest {

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
