package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentMethod;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
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
    private Set<Integer> enabledInstallments;
}