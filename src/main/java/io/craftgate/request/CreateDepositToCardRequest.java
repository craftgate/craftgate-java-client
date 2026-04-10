package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.DepositToCardPaymentIntegratorDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateDepositToCardRequest {

    private BigDecimal price;
    private Currency currency;
    private String description;
    private String orderId;
    private Card card;
    private DepositToCardPaymentIntegratorDto integrator;
}
