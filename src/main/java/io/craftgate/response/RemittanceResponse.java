package io.craftgate.response;

import io.craftgate.model.RemittanceReasonType;
import io.craftgate.model.RemittanceType;
import io.craftgate.model.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RemittanceResponse {

    private Long id;
    private LocalDateTime createdDate;
    private Status status;
    private BigDecimal price;
    private Long memberId;
    private RemittanceType remittanceType;
    private RemittanceReasonType remittanceReasonType;
    private String description;
}
