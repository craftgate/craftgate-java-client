package io.craftgate.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MealVoucherCardTokenizationData {

    private String cardNumber;

    private String userReferenceNumber;

    private String gsmNumber;

    private String callbackUrl;


    public static MealVoucherCardTokenizationData buildForMultinet(String userReferenceNumber, String callbackUrl){
       return MealVoucherCardTokenizationData.builder()
               .userReferenceNumber(userReferenceNumber)
               .callbackUrl(callbackUrl)
               .build();
    }

    public static MealVoucherCardTokenizationData buildForSetcard(String callbackUrl){
        return MealVoucherCardTokenizationData.builder()
                .callbackUrl(callbackUrl)
                .build();
    }

    public static MealVoucherCardTokenizationData buildForMetropol(String userReferenceNumber, String cardNumber, String gsmNumber){
        return MealVoucherCardTokenizationData.builder()
                .userReferenceNumber(userReferenceNumber)
                .cardNumber(cardNumber)
                .gsmNumber(gsmNumber)
                .build();
    }

    public static MealVoucherCardTokenizationData buildForPluxee(String callbackUrl){
        return MealVoucherCardTokenizationData.builder()
                .callbackUrl(callbackUrl)
                .build();
    }
}