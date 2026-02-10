package io.craftgate.request;

import io.craftgate.model.CardVerificationAuthType;
import io.craftgate.model.Currency;
import io.craftgate.request.dto.VerifyCard;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VerifyCardRequest {

    private VerifyCard card;
    private CardVerificationAuthType paymentAuthenticationType;
    private BigDecimal verificationPrice;
    private Currency currency;
    private String clientIp;
    private String conversationId;
    private String callbackUrl;
}
