package io.craftgate.request;

import io.craftgate.model.SettlementType;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPayoutCompletedTransactionsRequest extends BaseRequest {

    private Long settlementFileId;
    private SettlementType settlementType;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private Integer page;
    private Integer size;
}
