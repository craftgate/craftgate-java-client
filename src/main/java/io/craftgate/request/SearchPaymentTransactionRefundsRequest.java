package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.RefundStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPaymentTransactionRefundsRequest extends BaseRequest {

    private Integer page;
    private Integer size;
    private Long id;
    private Long paymentId;
    private Long paymentTransactionId;
    private Long buyerMemberId;
    private String conversationId;
    private RefundStatus status;
    private Currency currency;
    private BigDecimal minRefundPrice;
    private BigDecimal maxRefundPrice;
    private Boolean isAfterSettlement;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;
}
