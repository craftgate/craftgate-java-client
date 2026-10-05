package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MasterpassPaymentCompleteRequest extends BaseRequest {
    private String referenceId;
    private String token;
}
