package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.request.dto.GarantiPayInstallment;
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
public class InitGarantiPayPaymentRequest extends BaseRequest {

    protected BigDecimal price;
    protected BigDecimal paidPrice;
    protected Currency currency;
    protected String posAlias;
    protected PaymentGroup paymentGroup;
    protected String conversationId;
    protected String externalId;
    protected String callbackUrl;
    protected String clientIp;
    protected Integer clientPort;
    protected String paymentChannel;
    protected Long buyerMemberId;
    protected String bankOrderId;
    protected List<PaymentItem> items;
    protected List<GarantiPayInstallment> installments;
    private List<Integer> enabledInstallments;
}