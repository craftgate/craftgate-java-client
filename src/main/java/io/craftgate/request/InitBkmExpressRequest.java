package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.dto.PaymentItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class InitBkmExpressRequest extends BaseRequest {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private PaymentGroup paymentGroup;
    private String conversationId;
    private PaymentPhase paymentPhase;
    private List<PaymentItem> items;
    private List<Integer> enabledInstallments;
    private Long buyerMemberId;
    private Currency currency;
    private String bankOrderId;
}
