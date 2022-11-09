package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class InitApmPaymentRequest {

    private ApmType apmType;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private Long buyerMemberId;
    private Currency currency;
    private PaymentGroup paymentGroup;
    private String paymentChannel;
    private String conversationId;
    private String externalId;
    private String callbackUrl;
    private String apmOrderId;
    private String apmUserIdentity;
    private Map<String, String> additionalParams;
    private String clientIp;
    private List<PaymentItem> items;
}