package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.MealVoucherCardTokenizationCompleteRequest;
import io.craftgate.request.MealVoucherCardTokenizationCompleteResponse;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.MealVoucherCardTokenizationRegenerateRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;
import io.craftgate.response.MealVoucherCardTokenizationRegenerateResponse;

public class MealVoucherCardTokenizationAdapter extends BaseAdapter {

    public MealVoucherCardTokenizationAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MealVoucherCardTokenizationInitResponse cardTokenizationInit(MealVoucherCardTokenizationInitRequest mealVoucherCardTokenizationInitRequest) {
        return cardTokenizationInit(mealVoucherCardTokenizationInitRequest, null);
    }

    public MealVoucherCardTokenizationInitResponse cardTokenizationInit(MealVoucherCardTokenizationInitRequest mealVoucherCardTokenizationInitRequest, RequestContext requestContext) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationInitRequest, path, requestContext),
                mealVoucherCardTokenizationInitRequest, MealVoucherCardTokenizationInitResponse.class);
    }

    public MealVoucherCardTokenizationRegenerateResponse cardTokenizationRegenerate(MealVoucherCardTokenizationRegenerateRequest mealVoucherCardTokenizationRegenerateRequest) {
        return cardTokenizationRegenerate(mealVoucherCardTokenizationRegenerateRequest, null);
    }

    public MealVoucherCardTokenizationRegenerateResponse cardTokenizationRegenerate(MealVoucherCardTokenizationRegenerateRequest mealVoucherCardTokenizationRegenerateRequest, RequestContext requestContext) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/" + mealVoucherCardTokenizationRegenerateRequest.getSessionId() + "/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationRegenerateRequest, path, requestContext),
                mealVoucherCardTokenizationRegenerateRequest, MealVoucherCardTokenizationRegenerateResponse.class);
    }

    public MealVoucherCardTokenizationCompleteResponse cardTokenizationComplete(MealVoucherCardTokenizationCompleteRequest request) {
        return cardTokenizationComplete(request, null);
    }

    public MealVoucherCardTokenizationCompleteResponse cardTokenizationComplete(MealVoucherCardTokenizationCompleteRequest request, RequestContext requestContext) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, MealVoucherCardTokenizationCompleteResponse.class);
    }
}