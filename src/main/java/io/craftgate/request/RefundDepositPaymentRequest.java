package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RefundDepositPaymentRequest {

    private BigDecimal price;
    private String conversationId;
}
