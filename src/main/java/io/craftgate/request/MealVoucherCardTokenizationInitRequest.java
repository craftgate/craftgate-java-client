package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.request.dto.MealVoucherCardTokenizationData;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MealVoucherCardTokenizationInitRequest extends BaseRequest {

    private ApmType apmType;
    private MealVoucherCardTokenizationData mealVoucherCardTokenizationData;
}
