package io.craftgate.request;

import io.craftgate.model.ApmStatus;
import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class CreateMerchantApmRequest {

    @Builder.Default
    private ApmStatus status = ApmStatus.ACTIVE;
    private String name;
    private ApmType apmType;
    private String hostname;
    private List<Currency> supportedCurrencies;
    private Map<String, Object> properties;
}
