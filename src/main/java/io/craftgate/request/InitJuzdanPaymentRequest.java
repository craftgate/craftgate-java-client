package io.craftgate.request;

import io.craftgate.model.ClientType;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class InitJuzdanPaymentRequest {
    private BigDecimal price;
    private BigDecimal paidPrice;
    private Currency currency;
    private PaymentGroup paymentGroup;
    private String conversationId;
    private String externalId;
    private String callbackUrl;

    @Builder.Default
    private PaymentPhase paymentPhase = PaymentPhase.AUTH;
    private String paymentChannel;
    private Long buyerMemberId;
    private String bankOrderId;
    private List<CreatePaymentItemRequest> items;
    private ClientType clientType;
    private Long loanCampaignId;
}