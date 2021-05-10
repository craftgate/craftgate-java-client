package io.craftgate.response;

import lombok.Data;

@Data
public class InitCheckoutPaymentResponse {

    protected String token;
    protected String pageUrl;
}
