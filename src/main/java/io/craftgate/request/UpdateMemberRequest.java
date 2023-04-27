package io.craftgate.request;

import io.craftgate.model.MemberType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateMemberRequest {

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String identityNumber;
    private String contactName;
    private String contactSurname;
    private MemberType memberType;
    private String legalCompanyTitle;
    private String taxOffice;
    private String taxNumber;
    private String iban;
    /**
     * @deprecated use @{@link CreateWalletRequest#setNegativeAmountLimit(BigDecimal)} instead.
     */
    @Deprecated
    private BigDecimal negativeWalletAmountLimit;
    private Boolean isBuyer;
    private Boolean isSubMerchant;
}
