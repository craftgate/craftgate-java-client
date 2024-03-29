package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.request.dto.Card;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateDepositPaymentRequest {

    private Long buyerMemberId;
    private BigDecimal price;
    private Currency currency;
    private String conversationId;
    private String callbackUrl;
    private String posAlias;
    private String clientIp;
    private Card card;
}
