package io.craftgate.request;

import lombok.Data;

import java.util.Map;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CompleteApmPaymentRequest extends BaseRequest {

    private Long paymentId;
    private Map<String, String> additionalParams;
}