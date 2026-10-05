package io.craftgate.request;

import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PostAuthPaymentRequest extends BaseRequest {

    private BigDecimal paidPrice;
}
