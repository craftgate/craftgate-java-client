package io.craftgate.request;

import io.craftgate.model.FraudValueType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudValueListRequest {
    private String listName;
    private String label;
    private FraudValueType type;
    private String value;
    private Integer durationInSeconds;
    private Long paymentId;
}
