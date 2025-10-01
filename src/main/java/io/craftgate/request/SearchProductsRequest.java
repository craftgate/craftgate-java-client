package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SearchProductsRequest {

    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Currency currency;
    private String channel;
    private LocalDateTime minExpiresAt;
    private LocalDateTime maxExpiresAt;

    private Integer page = 0;
    private Integer size = 25;
}