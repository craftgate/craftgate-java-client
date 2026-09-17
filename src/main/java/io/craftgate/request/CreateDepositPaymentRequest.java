package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.RoutingOptions;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateDepositPaymentRequest extends BaseRequest {

    private Long buyerMemberId;
    private BigDecimal price;
    private Currency currency;
    private String conversationId;
    private String callbackUrl;
    private String posAlias;
    private String clientIp;
    private Integer clientPort;
    private Card card;
    private RoutingOptions routingOptions;
}
