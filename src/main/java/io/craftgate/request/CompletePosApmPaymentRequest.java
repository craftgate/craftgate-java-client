package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CompletePosApmPaymentRequest {

    private Long paymentId;
    private Map<String, Object> additionalParams;
}