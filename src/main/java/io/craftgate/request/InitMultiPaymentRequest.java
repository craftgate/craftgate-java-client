package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentMethod;
import io.craftgate.model.PaymentSource;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class InitMultiPaymentRequest {

    private BigDecimal price;
    private Currency currency;
    private PaymentGroup paymentGroup;
    private PaymentSource paymentSource;
    private String conversationId;
    private String externalId;
    private String callbackUrl;

    private String paymentChannel;

    private List<PaymentMethod> enabledPaymentMethods;
    private List<Integer> enabledInstallments;

    private String cardUserKey;

    private Long buyerMemberId;
    private boolean allowOnlyCreditCard;
    private boolean forceAuthForNonCreditCards;
    private boolean allowOnlyStoredCards;
    private boolean allowInstallmentOnlyCommercialCards;
    private boolean alwaysStoreCardAfterPayment;
    private boolean disableStoreCard;
    private boolean forceThreeDS;

    private String masterpassGsmNumber;
    private String masterpassUserId;
    private String apmUserIdentity;

    private List<PaymentItem> items;

    private Long ttl;
    private Integer maximumSplitPaymentCount;
    private Map<String, Object> additionalParams;
    private Boolean retry;
}
