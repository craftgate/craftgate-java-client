package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateMerchantRequest extends BaseRequest {

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
