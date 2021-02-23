package io.craftgate.response;

import io.craftgate.model.RefundStatus;
import io.craftgate.model.RefundType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DepositPaymentRefundResponse {

    private Long id;
    private Long paymentId;
    private String currency;
    private RefundStatus status;
    private String authCode;
    private String hostReference;
    private String transId;
    private String conversationId;
    private RefundType refundType;
    private BigDecimal refundPrice;
    private LocalDateTime createdDate;
}
