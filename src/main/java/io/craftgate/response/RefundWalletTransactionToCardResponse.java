package io.craftgate.response;

import io.craftgate.model.RefundStatus;
import io.craftgate.model.WalletTransactionRefundCardTransactionType;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RefundWalletTransactionToCardResponse {

    private Long id;
    private LocalDateTime createdDate;
    private RefundStatus refundStatus;
    private BigDecimal refundPrice;
    private String authCode;
    private String hostReference;
    private String transId;
    private Long transactionId;
    private WalletTransactionRefundCardTransactionType transactionType;
    private PaymentError paymentError;
    private Long walletTransactionId;
}