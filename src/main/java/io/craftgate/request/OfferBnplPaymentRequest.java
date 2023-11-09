package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.request.dto.BnplPaymentCartItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OfferBnplPaymentRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private BigDecimal price;
    private Currency currency;
    private List<BnplPaymentCartItem> items;

}
