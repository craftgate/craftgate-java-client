package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CloneCardRequest extends BaseRequest {

    private String sourceCardUserKey;
    private String sourceCardToken;
    private String targetCardUserKey;
    private Long targetMerchantId;
}
