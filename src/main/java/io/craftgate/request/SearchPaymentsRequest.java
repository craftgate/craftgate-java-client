package io.craftgate.request;

import io.craftgate.model.*;
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
    private Long buyerMemberId;
    private Long subMerchantMemberId;
    private String conversationId;
    private String externalId;
    private String orderId;
    private PaymentType paymentType;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
    private PaymentSource paymentSource;
    private String paymentChannel;
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
