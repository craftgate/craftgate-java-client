package io.craftgate.response.dto;

import lombok.Data;

import java.util.List;

@Data
public class BnplBankOffer {

    private String bankCode;
    private String bankName;
    private String bankIconUrl;
    private String bankTableBannerMessage;
    private String bankSmallBannerMessage;
    private String preApprovedApplicationId;
    private Boolean isSupportNonCustomer;
    private Boolean isPaymentPlanCalculatedByBank;
    private List<BnplBankOfferTerm> bankOfferTerms;
}
