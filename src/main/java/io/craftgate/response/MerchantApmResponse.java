package io.craftgate.response;

import io.craftgate.model.ApmStatus;
import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MerchantApmResponse {

    private Long id;
    private ApmStatus status;
    private String name;
    private ApmType apmType;
    private String hostname;
    private Long merchantId;
    private List<Currency> supportedCurrencies;
    private Map<String, Object> properties;
}