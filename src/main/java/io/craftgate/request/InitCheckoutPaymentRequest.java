package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class InitCheckoutPaymentRequest {

    protected BigDecimal price;
    protected BigDecimal paidPrice;
    protected Currency currency;
    protected PaymentGroup paymentGroup;
    protected String conversationId;
    protected String callbackUrl;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    protected String cardUserKey;

    protected Long buyerMemberId;
    protected List<Integer> enabledInstallments;
    protected boolean allowOnlySavedCards;
    protected List<PaymentItem> items;
}