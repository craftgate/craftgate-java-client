package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.TransactionPayoutStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchWithdrawsRequest extends BaseRequest {

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