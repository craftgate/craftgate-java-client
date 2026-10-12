package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ApplePayMerchantSessionCreateRequest extends BaseRequest {

    private String merchantIdentifier;
    private String displayName;
    private String initiative;
    private String initiativeContext;
    private String validationUrl;
}
