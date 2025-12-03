package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String orderId;
    private String conversationId;
    private String externalId;
    private Status status;
    private BigDecimal price;
    private Currency currency;
    private Integer stock;
    private Integer soldCount;
    private String token;
    private Set<Integer> enabledInstallments;
    private String url;
    private String channel;
    private LocalDateTime expiresAt;
}
