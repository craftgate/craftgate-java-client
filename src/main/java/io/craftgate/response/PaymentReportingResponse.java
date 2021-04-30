package io.craftgate.response;

import io.craftgate.model.*;
import io.craftgate.response.dto.Member;
import io.craftgate.response.dto.PaymentCard;
import io.craftgate.response.dto.PaymentRefund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReportingResponse {

    private Long id;
    private LocalDateTime createdDate;
    private Currency currency;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private PaymentType paymentType;
    private PaymentGroup paymentGroup;
    private PaymentStatus paymentStatus;
    private String conversationId;
    private String externalId;
    private Long merchantId;
    private String orderId;
    private Integer retryCount;
    private BigDecimal refundablePrice;
    private PaymentRefundStatus refundStatus;
    private Member buyerMember;
    private PaymentCard paymentCard;
    private List<PaymentRefund> refunds;
}
