package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchProductsRequest extends BaseRequest {

    private Long id;
    private String name;
    private String orderId;
    private String conversationId;
    private String externalId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Currency currency;
    private String channel;
    private LocalDateTime minExpiresAt;
    private LocalDateTime maxExpiresAt;

    @Builder.Default
    private Integer page = 0;
    @Builder.Default
    private Integer size = 25;
}