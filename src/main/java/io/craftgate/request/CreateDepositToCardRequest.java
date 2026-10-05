package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.DepositToCardPaymentIntegratorDto;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateDepositToCardRequest extends BaseRequest {

    private BigDecimal price;
    private Currency currency;
    private String description;
    private String orderId;
    private Card card;
    private DepositToCardPaymentIntegratorDto integrator;
}
