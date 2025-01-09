package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.request.dto.BnplPaymentCartItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class BnplPaymentOfferRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private BigDecimal price;
    private Currency currency;
    private Map<String, Object> additionalParams;
    private List<BnplPaymentCartItem> items;

}
