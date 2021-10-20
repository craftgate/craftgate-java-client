package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
public class CreatePaymentRequest {

    protected BigDecimal price;
    protected BigDecimal paidPrice;

    @Builder.Default
    protected BigDecimal walletPrice = BigDecimal.ZERO;

    protected String posAlias;
    protected Integer installment;
    protected Currency currency;
    protected PaymentGroup paymentGroup;
    protected String conversationId;
    protected String externalId;
    protected String clientIp;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    protected String paymentChannel;
    protected Long buyerMemberId;
    protected Card card;
    protected List<PaymentItem> items;
    protected Map<String, Map<String, Object>> additionalParams;
}
