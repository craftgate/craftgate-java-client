package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.request.dto.PaymentItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateApmPaymentRequest extends BaseRequest {

    private ApmType apmType;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private Currency currency;
    private PaymentGroup paymentGroup;
    private String paymentChannel;
    private String conversationId;
    private String externalId;
    private Long buyerMemberId;
    private String apmOrderId;
    private String clientIp;
    private List<PaymentItem> items;
}