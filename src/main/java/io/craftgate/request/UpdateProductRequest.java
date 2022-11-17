package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class UpdateProductRequest {

    private String name;
    private String channel;
    private String orderId;
    private String conversationId;
    private String externalId;
    private Status status;
    private Integer stock;
    private BigDecimal price;
    private Currency currency;
    private String description;
    private Set<Integer> enabledInstallments;
}