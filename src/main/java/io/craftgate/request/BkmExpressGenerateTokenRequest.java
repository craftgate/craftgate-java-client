package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Builder
public class BkmExpressGenerateTokenRequest extends BaseRequest {

    private String gsmNumber;
    private String userId;
}
