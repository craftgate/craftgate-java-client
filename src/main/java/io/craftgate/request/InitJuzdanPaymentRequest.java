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
    private List<PaymentItem> items;
    private ClientType clientType;
    private Long loanCampaignId;

    public enum ClientType {
        M,
        W
    }
}