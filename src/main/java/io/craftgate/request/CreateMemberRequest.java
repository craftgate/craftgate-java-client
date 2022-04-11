package io.craftgate.request;

import io.craftgate.model.MemberType;
import io.craftgate.model.SettlementEarningsDestination;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateMemberRequest {

    private String memberExternalId;
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
    private SettlementEarningsDestination settlementEarningsDestination;
    private BigDecimal negativeWalletAmountLimit;
    private Boolean isBuyer;
    private Boolean isSubMerchant;
}
