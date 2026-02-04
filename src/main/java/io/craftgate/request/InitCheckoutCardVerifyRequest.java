package io.craftgate.request;

import io.craftgate.model.CardVerificationAuthType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InitCheckoutCardVerifyRequest {

    private BigDecimal verificationPrice;
    private Currency currency;
    private String conversationId;
    private String callbackUrl;
    private String cardUserKey;
    private CardVerificationAuthType paymentAuthenticationType;
    private Long ttl;

}