package io.craftgate.request;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudCheckStatus;
import io.craftgate.model.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchFraudChecksRequest {
    private Integer page;
    private Integer size;
    private FraudAction action;
    private FraudCheckStatus checkStatus;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;
    private Long ruleId;
    private Long paymentId;
    private PaymentStatus paymentStatus;
}
