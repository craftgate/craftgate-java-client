package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.RefundStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SearchRefundsRequest {

    private Integer page;
    private Integer size;
    private Long id;
    private Long paymentId;
    private Long buyerMemberId;
    private String conversationId;
    private Long merchantPosId;
    private RefundStatus refundStatus;
    private Currency currency;
    private BigDecimal minRefundPrice;
    private BigDecimal maxRefundPrice;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;

}
