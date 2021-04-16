package io.craftgate.response.dto;

import lombok.Data;

@Data
public class PayoutBouncedTransaction {

    private Long id;
    private String iban;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
}