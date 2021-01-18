package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTransactionRefundResponse {

    private Long id;
    private String conversationId;
    private LocalDateTime createdDate;
    private RefundStatus status;
    private Boolean isAfterSettlement;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private Currency currency;
    private Long paymentTransactionId;
    private Long paymentId;
    private RefundDestinationType refundDestinationType;
}
