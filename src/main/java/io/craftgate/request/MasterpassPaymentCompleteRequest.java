package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterpassPaymentCompleteRequest {
    private String referenceId;
    private String token;
}
