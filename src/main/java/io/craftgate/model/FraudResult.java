package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudResult {
    private Long id;
    private Double score;
    private FraudAction action;
}
