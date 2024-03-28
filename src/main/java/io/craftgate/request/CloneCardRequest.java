package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloneCardRequest {

    private String sourceCardUserKey;
    private String sourceCardToken;
    private String targetCardUserKey;
    private Long targetMerchantId;
}
