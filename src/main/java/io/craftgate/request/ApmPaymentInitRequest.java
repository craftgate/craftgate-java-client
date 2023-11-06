package io.craftgate.request;

import io.craftgate.model.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
public class ApmPaymentInitRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal commissionRate;
    private Currency currency;
    private PaymentType paymentType = PaymentType.APM;
    private PaymentGroup paymentGroup;
    private PaymentSource paymentSource;
    private String paymentChannel;
    private String conversationId;
    private String externalId;
    private String callbackUrl;
    private Long buyerMemberId;
    private String apmOrderId;
    private String clientIp;
    private String checkoutFormToken;
    private String apmUserIdentity;
    private Map<String, Object> additionalParams;
    private List<CreatePaymentItemRequest> items;
}
