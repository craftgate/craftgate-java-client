package io.craftgate.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitCheckoutPaymentResponse {

    protected String token;
    protected String pageUrl;
}