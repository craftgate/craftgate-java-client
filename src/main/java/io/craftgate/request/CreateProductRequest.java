package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class CreateProductRequest {

    private String name;
    private String channel;
    private String orderId;
    private String conversationId;
    private String externalId;
    private Integer stock;
    private BigDecimal price;
    private Currency currency;
    private String description;
    private boolean multiPayment;
    private Set<Integer> enabledInstallments;
}