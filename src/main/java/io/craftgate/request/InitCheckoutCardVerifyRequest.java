package io.craftgate.request;

import io.craftgate.model.CardVerificationAuthType;
import io.craftgate.model.Currency;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class InitCheckoutCardVerifyRequest extends BaseRequest {

    private BigDecimal verificationPrice;
    private Currency currency;
    private String conversationId;
    private String callbackUrl;
    private String cardUserKey;
    private CardVerificationAuthType paymentAuthenticationType;
    private Long ttl;

}