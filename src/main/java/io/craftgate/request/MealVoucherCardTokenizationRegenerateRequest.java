package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.dto.MealVoucherCardTokenizationData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealVoucherCardTokenizationRegenerateRequest extends BaseRequest {

    private MealVoucherCardTokenizationData mealVoucherCardTokenizationData;
}
