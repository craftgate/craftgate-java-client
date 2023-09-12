package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterpassPaymentThreeDSInitRequest {
    private String referenceId;
    private String callbackUrl;
}
