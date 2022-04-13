package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SearchProductsRequest {

    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Currency currency;
    private String channel;

    private Integer page = 0;
    private Integer size = 25;
}