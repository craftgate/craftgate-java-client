package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SearchInstallmentsRequest {

    private String binNumber;
    private BigDecimal price;
    private Currency currency;
    private boolean distinctCardBrandsWithLowestCommissions;
    private boolean loyaltyExists;
}
