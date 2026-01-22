package io.craftgate.request;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudOperation;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchFraudRuleRequest {

    private Integer page;
    private Integer size;
    private String name;
    private FraudAction action;
    private FraudOperation operation;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;

}
