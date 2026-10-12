package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateProductRequest extends BaseRequest {

    private String name;
    private String channel;
    private String orderId;
    private String conversationId;
    private String externalId;
    private Integer stock;
    private BigDecimal price;
    private Currency currency;
    private LocalDateTime expiresAt;
    private String description;
    private boolean multiPayment;
    private boolean forceThreeDS;
    private Set<Integer> enabledInstallments;
    private String basketIdentifier;
}