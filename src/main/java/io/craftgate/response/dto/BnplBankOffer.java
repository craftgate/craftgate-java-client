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
    private Boolean isSupportNonCustomer;
    private List<BnplBankOfferTerm> bankOfferTerms;
}
