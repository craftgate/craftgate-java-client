package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.model.PosApmPaymentProvider;
import io.craftgate.request.dto.FraudCheckParameters;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.request.dto.PosApmInstallment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class InitPosApmPaymentRequest extends BaseRequest {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private String posAlias;
    private Currency currency;
    private String conversationId;
    private String externalId;
    private String callbackUrl;
    private PaymentGroup paymentGroup;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    private String paymentChannel;
    private Long buyerMemberId;
    private String bankOrderId;
    private String clientIp;
    protected List<PaymentItem> items;
    private Map<String, Object> additionalParams;
    private List<PosApmInstallment> installments;
    private PosApmPaymentProvider paymentProvider;
    private FraudCheckParameters fraudParams;
    private String checkoutFormToken;
}