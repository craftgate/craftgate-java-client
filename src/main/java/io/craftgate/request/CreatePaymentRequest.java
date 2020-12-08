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

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    protected Long buyerMemberId;
    protected Card card;
    protected List<PaymentItem> items;
}
