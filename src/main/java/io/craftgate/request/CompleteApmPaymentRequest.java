package io.craftgate.request;

import lombok.Builder;
import lombok.Data;
import java.util.Map;

@Data
@Builder
public class CompleteApmPaymentRequest {

    private Long paymentId;
    private Map<String, String> additionalParams;
}