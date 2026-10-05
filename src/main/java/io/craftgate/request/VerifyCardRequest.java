package io.craftgate.request;

import io.craftgate.model.CardVerificationAuthType;
import io.craftgate.model.Currency;
import io.craftgate.request.dto.VerifyCard;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class VerifyCardRequest extends BaseRequest {

    private VerifyCard card;
    private CardVerificationAuthType paymentAuthenticationType;
    private BigDecimal verificationPrice;
    private Currency currency;
    private String clientIp;
    private Integer clientPort;
    private String conversationId;
    private String callbackUrl;
}
