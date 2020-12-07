package io.craftgate.response;

import lombok.Data;
import io.craftgate.model.Currency;
import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import io.craftgate.model.RefundType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentRefundResponse {

    private Long id;
    private String conversationId;
    private LocalDateTime createdDate;
    private RefundStatus status;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private RefundType refundType;
    private RefundDestinationType refundDestinationType;
    private Currency currency;
    private Long paymentId;
    private List<PaymentTransactionRefundResponse> paymentTransactionRefunds;
}
