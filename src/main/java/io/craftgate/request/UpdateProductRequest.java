package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateProductRequest {

    private String name;
    private String channel;
    private Status status;
    private BigDecimal price;
    private Currency currency;
    protected String description;
    private String enabledInstallments;
}