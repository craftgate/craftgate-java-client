package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateWithdrawRequest {

    private BigDecimal price;
    private Long memberId;
    private String description;
    private Currency currency;
}