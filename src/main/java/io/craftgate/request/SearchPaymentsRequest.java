package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentStatus;
import io.craftgate.model.PaymentType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SearchPaymentsRequest {

    private Integer page;
    private Integer size;
    private Long paymentId;
    private Long paymentTransactionId;
    private Long subMerchantMemberId;
    private Long buyerMemberId;
    private String conversationId;
    private String externalId;
    private Long merchantPosId;
    private String orderId;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private String binNumber;
    private String lastFourDigits;
    private Currency currency;
    private BigDecimal minPaidPrice;
    private BigDecimal maxPaidPrice;
    private Integer installment;
    private Boolean isThreeDS;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;
}
