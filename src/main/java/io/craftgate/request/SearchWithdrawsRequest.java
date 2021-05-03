package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.TransactionPayoutStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SearchWithdrawsRequest {

    private Long memberId;
    private Currency currency;
    private TransactionPayoutStatus payoutStatus;
    private BigDecimal minWithdrawPrice;
    private BigDecimal maxWithdrawPrice;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}