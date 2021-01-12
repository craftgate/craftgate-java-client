package io.craftgate.request;

import io.craftgate.model.RemittanceReasonType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateRemittanceRequest {

    private Long memberId;
    private BigDecimal price;
    private String description;
    private RemittanceReasonType remittanceReasonType;
}
