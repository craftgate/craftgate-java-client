package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateWalletRequest {

    private BigDecimal negativeAmountLimit;
    private Currency currency;
}