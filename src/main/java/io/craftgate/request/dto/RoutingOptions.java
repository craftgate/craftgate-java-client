package io.craftgate.request.dto;

import java.util.List;

public class RoutingOptions {

    private OrderingRule orderingRule;
    private List<String> posAliases;

    public enum OrderingRule {
        ON_US,
        LOW_COMMISSION_RATE,
        IN_ORDER
    }
}
