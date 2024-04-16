package io.craftgate.response;

import io.craftgate.model.MultiPaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MultiPaymentResponse {

    private Long id;
    private MultiPaymentStatus multiPaymentStatus;
    private String token;
    private String conversationId;
    private String externalId;
    private BigDecimal paidPrice;
    private BigDecimal remainingAmount;
    private LocalDateTime tokenExpireDate;
    private Set<Long> paymentIds;
}
