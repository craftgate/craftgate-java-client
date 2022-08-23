package io.craftgate.request;

import io.craftgate.model.FraudCheckStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateFraudCheckRequest {
    private FraudCheckStatus checkStatus;
}
