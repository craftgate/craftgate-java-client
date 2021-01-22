package io.craftgate.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class InitCheckoutPaymentResponse {

    protected String token;
    protected String pageUrl;
}