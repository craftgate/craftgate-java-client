package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.RemittanceReasonType;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateRemittanceRequest extends BaseRequest {

    private Long memberId;
    private BigDecimal price;
    private Currency currency;
    private String description;
    private RemittanceReasonType remittanceReasonType;
}
