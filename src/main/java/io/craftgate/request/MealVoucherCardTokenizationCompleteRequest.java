package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealVoucherCardTokenizationCompleteRequest {

    private String validationCode;
}
