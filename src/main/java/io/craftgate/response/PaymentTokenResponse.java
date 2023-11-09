package io.craftgate.response;

import lombok.Data;

@Data
public class PaymentTokenResponse {

    private String token;
    private String issuer;
}
