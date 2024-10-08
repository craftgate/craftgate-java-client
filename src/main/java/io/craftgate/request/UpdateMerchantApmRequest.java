package io.craftgate.request;

import io.craftgate.model.ApmStatus;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class UpdateMerchantApmRequest {
    private String name;
    private String hostname;
    private ApmStatus status;
    private List<Currency> supportedCurrencies;
    private Map<String, Object> properties;
}