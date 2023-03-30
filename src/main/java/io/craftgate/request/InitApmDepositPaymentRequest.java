package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
public class InitApmDepositPaymentRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private BigDecimal price;
    private Currency currency;
    private Long buyerMemberId;
    private String paymentChannel;
    private String conversationId;
    private String externalId;
    private String callbackUrl;
    private String apmOrderId;
    private String apmUserIdentity;
    private Map<String, Object> additionalParams;
    private String clientIp;
}
