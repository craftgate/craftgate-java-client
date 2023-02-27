package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchMerchantPosRequest {
    private String name;
    private String alias;
    private Currency currency;
    private Boolean forceThreeDs;
    private Boolean enableInstallment;
    private Boolean enableForeignCard;
    private String bankName;
    private Integer page;
    private Integer size;

}