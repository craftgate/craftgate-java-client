package io.craftgate.response.common;

import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BasePaymentTransactionRefundResponse {

    private Long id;
    private LocalDateTime createdDate;
    private RefundStatus status;
    private RefundDestinationType refundDestinationType;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private String conversationId;
    private String authCode;
    private String hostReference;
    private String transId;
    private Boolean isAfterSettlement;
}
