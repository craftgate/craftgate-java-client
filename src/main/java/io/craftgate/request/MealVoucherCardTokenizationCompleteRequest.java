package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealVoucherCardTokenizationCompleteRequest extends BaseRequest {

    private String validationCode;
}
