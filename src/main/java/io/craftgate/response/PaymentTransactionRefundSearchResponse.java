package io.craftgate.response;

import io.craftgate.model.PaymentType;
import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTransactionRefundSearchResponse {

    private Long id;
    private String conversationId;
    private LocalDateTime createdDate;
    private RefundStatus refundStatus;
    private Boolean isAfterSettlement;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private PaymentType paymentType;
    private String authCode;
    private String hostReference;
    private String transId;
    private RefundDestinationType refundDestinationType;
    private PaymentError error;

}
