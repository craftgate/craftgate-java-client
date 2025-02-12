package io.craftgate.response.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BkmExpressToken {

    private String id;
    private String path;
    private String token;
}
