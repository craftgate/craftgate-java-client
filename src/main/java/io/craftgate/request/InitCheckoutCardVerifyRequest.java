package io.craftgate.request;

import io.craftgate.model.CardVerificationAuthType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InitCheckoutCardVerifyRequest {

    protected BigDecimal verificationPrice;
    protected Currency currency;
    protected String conversationId;
    protected String callbackUrl;
    protected String cardUserKey;
    protected CardVerificationAuthType paymentAuthenticationType;
    protected Long ttl;

}