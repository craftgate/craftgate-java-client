package io.craftgate.response;

import lombok.Data;

@Data
public class CheckMasterpassUserResponse {

    private Boolean isEligibleToUseMasterpass;
    private Boolean isAnyCardSavedInCustomerProgram;
    private Boolean hasMasterpassAccount;
    private Boolean hashAnyCardSavedInMasterpassAccount;
    private Boolean isMasterpassAccountLinkedWithMerchant;
    private Boolean isMasterpassAccountLocked;
    private Boolean isPhoneNumberUpdatedInAnotherMerchant;
    private String accountStatus;
}
