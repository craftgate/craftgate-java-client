package io.craftgate.request;

import io.craftgate.model.FraudCheckStatus;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdateFraudCheckRequest extends BaseRequest {
    private FraudCheckStatus checkStatus;
}
