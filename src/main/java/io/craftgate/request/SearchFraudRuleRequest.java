package io.craftgate.request;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudOperation;
import io.craftgate.model.FraudRuleScope;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchFraudRuleRequest extends BaseRequest {

    private Integer page;
    private Integer size;
    private String name;
    private FraudAction action;
    private FraudOperation operation;
    private FraudRuleScope scope;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;

}
