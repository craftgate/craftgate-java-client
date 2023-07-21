package io.craftgate.response;

import io.craftgate.model.BankAccountTrackingSource;
import io.craftgate.model.Currency;
import io.craftgate.model.RecordType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BankAccountTrackingRecordResponse {

    private Long id;
    private String key;
    private Currency currency;
    private RecordType recordType;
    private String senderName;
    private String senderIban;
    private String description;
    private LocalDateTime recordDate;
    private BigDecimal amount;
    private BankAccountTrackingSource bankAccountTrackingSource;
}
