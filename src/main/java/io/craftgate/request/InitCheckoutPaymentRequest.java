package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentMethod;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.dto.CustomInstallment;
import io.craftgate.request.dto.FraudCheckParameters;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class InitCheckoutPaymentRequest {

    protected BigDecimal price;
    protected BigDecimal paidPrice;
    protected Currency currency;
    protected PaymentGroup paymentGroup;
    protected String conversationId;
    protected String externalId;
    protected String orderId;
    protected String callbackUrl;
    protected String clientIp;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;
    protected String paymentChannel;

    protected List<PaymentMethod> enabledPaymentMethods;
    protected String masterpassGsmNumber;
    protected String masterpassUserId;

    protected String cardUserKey;

    protected Long buyerMemberId;
    protected List<Integer> enabledInstallments;
    protected boolean alwaysStoreCardAfterPayment;
    protected boolean allowOnlyStoredCards;
    protected boolean allowOnlyCreditCard;
    protected boolean allowInstallmentOnlyCommercialCards;
    protected boolean forceThreeDS;
    protected boolean forceAuthForNonCreditCards;
    protected boolean depositPayment;
    protected boolean guestCheckout;
    protected boolean allowDeleteStoredCard = true;
    protected String returnBackUrl;
    protected Long ttl;
    protected List<CustomInstallment> customInstallments;
    protected List<PaymentItem> items;
    protected FraudCheckParameters fraudParams;
    protected Map<String, Object> additionalParams;
    protected Map<String, List<CustomInstallment>> cardBrandInstallments;
}