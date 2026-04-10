package io.craftgate.response;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudOperation;
import io.craftgate.model.Status;
import lombok.Data;

import java.util.List;

@Data
public class FraudRuleResponse {
    private Long id;
    private Status status;
    private String name;
    private FraudAction action;
    private String conditions;
    private List<FraudOperation> operations;
}
