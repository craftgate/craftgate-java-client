package io.craftgate.response;

import io.craftgate.model.FraudAction;
import io.craftgate.model.PaymentStatus;
import io.craftgate.model.PaymentType;
import io.craftgate.response.dto.WalletTransaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DepositPaymentResponse {

    private Long id;
    private BigDecimal price;
    private String currency;
    private Long buyerMemberId;
    private String conversationId;
    private BigDecimal bankCommissionRate;
    private BigDecimal bankCommissionRateAmount;
    private String authCode;
    private String hostReference;
    private String transId;
    private String orderId;
    private PaymentType paymentType;
    private LocalDateTime createdDate;
    private PaymentStatus paymentStatus;
    private String cardUserKey;
    private String cardToken;
    private WalletTransaction walletTransaction;
    private Long fraudId;
    private Long fraudRuleId;
    private FraudAction fraudAction;
}
