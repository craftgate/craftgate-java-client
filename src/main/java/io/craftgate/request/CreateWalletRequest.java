package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateWalletRequest extends BaseRequest {

    private BigDecimal negativeAmountLimit;
    private Currency currency;
}