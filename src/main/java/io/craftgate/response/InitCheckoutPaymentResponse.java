package io.craftgate.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InitCheckoutPaymentResponse {

    protected String token;
    protected String pageUrl;
    protected LocalDateTime tokenExpireDate;
}
