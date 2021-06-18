package io.craftgate.response.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayoutBouncedTransaction {

    private Long id;
    private String iban;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long payoutId;
    private BigDecimal payoutAmount;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    private String rowDescription;
}