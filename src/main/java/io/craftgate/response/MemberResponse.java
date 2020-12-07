package io.craftgate.response;

import io.craftgate.model.MemberType;
import io.craftgate.model.SettlementEarningsDestination;
import io.craftgate.model.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Status status;
    private Boolean isBuyer;
    private Boolean isSubMerchant;
    private SettlementEarningsDestination settlementEarningsDestination;
    private MemberType memberType;
    private String memberExternalId;
    private String name;
    private String address;
    private String email;
    private String gsmNumber;
    private String contactName;
    private String contactSurname;
    private String identityNumber;
    private String iban;
    private String legalCompanyTitle;
    private String taxOffice;
    private String taxNumber;
}
