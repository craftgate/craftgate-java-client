package io.craftgate.response.common;

import lombok.Data;

@Data
public class ProviderError {

    private String errorCode;
    private String errorMessage;
}
