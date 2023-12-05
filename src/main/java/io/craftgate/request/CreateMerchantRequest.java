package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CreateMerchantRequest {

    private String name;
    private String legalCompanyTitle;
    private String email;
    private String secretWord;
    private String website;
    private String phoneNumber;
    private String contactName;
    private String contactSurname;
    private String contactPhoneNumber;
}
