package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.MealVoucherCardTokenizationCompleteRequest;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.MealVoucherCardTokenizationRegenerateRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MealVoucherCardTokenizationCompleteResponse;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;
import io.craftgate.response.MealVoucherCardTokenizationRegenerateResponse;

public class MealVoucherCardTokenizationAdapter extends BaseAdapter {

    public MealVoucherCardTokenizationAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MealVoucherCardTokenizationInitResponse cardTokenizationInit(MealVoucherCardTokenizationInitRequest mealVoucherCardTokenizationInitRequest) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationInitRequest, path, requestOptions),
                mealVoucherCardTokenizationInitRequest, MealVoucherCardTokenizationInitResponse.class);
    }

    public MealVoucherCardTokenizationRegenerateResponse cardTokenizationRegenerate(String sessionId, MealVoucherCardTokenizationRegenerateRequest mealVoucherCardTokenizationRegenerateRequest) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/" + sessionId + "/regenerate";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationRegenerateRequest, path, requestOptions),
                mealVoucherCardTokenizationRegenerateRequest, MealVoucherCardTokenizationRegenerateResponse.class);
    }

    public MealVoucherCardTokenizationCompleteResponse cardTokenizationComplete(String sessionId, MealVoucherCardTokenizationCompleteRequest request) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/" + sessionId + "/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, MealVoucherCardTokenizationCompleteResponse.class);
    }
}