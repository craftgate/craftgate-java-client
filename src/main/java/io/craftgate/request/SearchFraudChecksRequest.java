package io.craftgate.request;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudCheckStatus;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchFraudChecksRequest extends BaseRequest {
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
