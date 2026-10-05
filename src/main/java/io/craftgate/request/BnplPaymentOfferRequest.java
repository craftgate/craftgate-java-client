package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.request.dto.BnplPaymentCartItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class BnplPaymentOfferRequest extends BaseRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private BigDecimal price;
    private Currency currency;
    private String apmOrderId;
    private Map<String, Object> additionalParams;
    private List<BnplPaymentCartItem> items;

}
