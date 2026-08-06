package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class MealVoucherCardTokenizationCompleteRequest extends BaseRequest {

    private String validationCode;
}
