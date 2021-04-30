package io.craftgate.response;

import io.craftgate.model.PaymentType;
import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentRefundSearchResponse {

    private Long id;
    private LocalDateTime createdDate;
    private RefundStatus refundStatus;
    private PaymentType paymentType;
    private RefundDestinationType refundDestinationType;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private String conversationId;
    private String authCode;
    private String hostReference;
    private String transId;
    private PaymentError error;
    private PaymentReportingResponse payment;
}
