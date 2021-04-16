package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchPayoutBouncedTransactionsRequest {

    private LocalDateTime endDate;
    private LocalDateTime startDate;
}
