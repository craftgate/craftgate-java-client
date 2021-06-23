package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PostAuthPaymentRequest {

    private Long paymentId;
    private BigDecimal paidPrice;
}
