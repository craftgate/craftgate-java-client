package io.craftgate.response;

import io.craftgate.model.MemberType;
import io.craftgate.model.SettlementEarningsDestination;
import io.craftgate.model.Status;
import io.craftgate.request.CreateWalletRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MemberResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Status status;
    private Boolean isBuyer;
    private Boolean isSubMerchant;
    private MemberType memberType;
    private String memberExternalId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    private String taxOffice;
    private String taxNumber;
    private SettlementEarningsDestination settlementEarningsDestination;
    /**
     * @deprecated use @{@link CreateWalletRequest#setNegativeAmountLimit(BigDecimal)} instead.
     */
    @Deprecated
    private BigDecimal negativeWalletAmountLimit;
    private String iban;
}
