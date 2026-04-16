package io.craftgate.request;

import io.craftgate.model.ApmType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealVoucherCardTokenizationInitRequest {

    private ApmType apmType;
    private String mealVoucherIdentifier;
    private String callbackUrl;
}
