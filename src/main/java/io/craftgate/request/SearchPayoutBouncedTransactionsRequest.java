package io.craftgate.request;

import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPayoutBouncedTransactionsRequest extends BaseRequest {

    private LocalDateTime endDate;
    private LocalDateTime startDate;
}
