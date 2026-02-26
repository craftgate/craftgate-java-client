package io.craftgate.response.common;

import lombok.Data;

@Data
public class ErrorResponse {

    private String errorCode;
    private String errorDescription;
    private String errorGroup;
    private ProviderError providerError;
}
