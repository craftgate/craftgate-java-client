package io.craftgate.response;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import lombok.Data;

import java.util.List;

@Data
public class MerchantApmResponse {

    private Long id;
    private Status status;
    private String name;
    private ApmType apmType;
    private String hostname;
    private List<Currency> supportedCurrencies;
}