package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplePayMerchantSessionCreateRequest {

    private String merchantIdentifier;
    private String displayName;
    private String initiative;
    private String initiativeContext;
    private String validationUrl;
}
