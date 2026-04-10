package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateDepositToCardPaymentResponse {

    private Long id;
    private LocalDateTime createdDate;
    private BigDecimal price;
    private String referenceId;
    private PaymentStatus paymentStatus;
    private Currency currency;
    private String description;
    private String orderId;
}