package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentTokenRequest {

    private String value;
    private String issuer;
}
