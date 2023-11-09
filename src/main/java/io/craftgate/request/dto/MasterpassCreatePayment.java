package io.craftgate.request.dto;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class MasterpassCreatePayment {
    protected BigDecimal price;
    protected BigDecimal paidPrice;
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
    protected String bankOrderId;
    protected List<PaymentItem> items;
    protected Map<String, Object> additionalParams;
}
