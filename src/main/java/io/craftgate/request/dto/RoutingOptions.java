package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoutingOptions {

    private OrderingRule orderingRule;
    private List<String> posAliases;
    private Boolean ignoreAdvancedPosRoutingRules;

    public enum OrderingRule {
        ON_US,
        LOW_COMMISSION_RATE,
        IN_ORDER
    }
}
