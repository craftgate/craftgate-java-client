package io.craftgate.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitBkmExpressResponse {

    private String id;
    private String path;
    private String token;
}
