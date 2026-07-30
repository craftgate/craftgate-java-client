package io.craftgate.request;

import io.craftgate.model.FraudCheckStatus;
import io.craftgate.request.common.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class UpdateFraudCheckStatusRequest extends BaseRequest {

    private Long id;
    private FraudCheckStatus checkStatus;
}
