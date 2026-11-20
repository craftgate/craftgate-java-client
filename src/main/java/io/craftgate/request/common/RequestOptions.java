package io.craftgate.request.common;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class RequestOptions {

    @ToString.Exclude
    private String apiKey;
    @ToString.Exclude
    private String secretKey;
    private String baseUrl;
    private String language;
}
