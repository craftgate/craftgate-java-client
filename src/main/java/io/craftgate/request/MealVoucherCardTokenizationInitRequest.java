package io.craftgate.request;

import io.craftgate.model.ApmType;
import io.craftgate.request.dto.MealVoucherCardTokenizationData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealVoucherCardTokenizationInitRequest {

    private ApmType apmType;
    private MealVoucherCardTokenizationData mealVoucherCardTokenizationData;
}
