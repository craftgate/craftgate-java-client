package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BkmExpressGenerateTokenRequest {

    private String gsmNumber;
    private String userId;
}
