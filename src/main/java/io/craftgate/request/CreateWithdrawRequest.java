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
public class CreateWithdrawRequest extends BaseRequest {

    private BigDecimal price;
    private Long memberId;
    private String description;
    private Currency currency;
}