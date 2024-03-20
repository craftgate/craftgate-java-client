package io.craftgate.request;

import io.craftgate.model.SettlementType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchPayoutCompletedTransactionsRequest {

    private Long settlementFileId;
    private SettlementType settlementType;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private Integer page;
    private Integer size;
}
