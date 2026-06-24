package io.craftgate.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BkmExpressGenerateTokenResponse {

    private String token;
    private String errorCode;
    private String errorMessage;
}
