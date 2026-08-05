package io.craftgate.request;

import io.craftgate.model.FraudValueType;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class FraudValueListRequest extends BaseRequest {
    private String listName;
    private String label;
    private FraudValueType type;
    private String value;
    private Integer durationInSeconds;
    private Long paymentId;
}
