package io.craftgate.request.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FraudPaymentData {
    private LocalDateTime paymentDate;
    private String conversationId;
    private BigDecimal paidPrice;
    private String currency;
    private String cardFingerprintId;
    private LocalDateTime cardFingerprintExpirationDate;
    private Long buyerId;
    private String clientIp;
}
