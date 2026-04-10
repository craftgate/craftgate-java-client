package io.craftgate.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InitCheckoutCardVerifyResponse {

    private String token;
    private String pageUrl;
    private LocalDateTime tokenExpireDate;
}
