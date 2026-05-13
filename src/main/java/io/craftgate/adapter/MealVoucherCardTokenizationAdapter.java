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

    public MealVoucherCardTokenizationRegenerateResponse cardTokenizationRegenerate(String sessionId, MealVoucherCardTokenizationRegenerateRequest mealVoucherCardTokenizationRegenerateRequest) {
        return cardTokenizationRegenerate(sessionId, mealVoucherCardTokenizationRegenerateRequest, null);
    }

    public MealVoucherCardTokenizationRegenerateResponse cardTokenizationRegenerate(String sessionId, MealVoucherCardTokenizationRegenerateRequest mealVoucherCardTokenizationRegenerateRequest, RequestContext requestContext) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/" + sessionId + "/regenerate";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationRegenerateRequest, path, requestContext),
                mealVoucherCardTokenizationRegenerateRequest, MealVoucherCardTokenizationRegenerateResponse.class);
    }

    public MealVoucherCardTokenizationCompleteResponse cardTokenizationComplete(String sessionId, MealVoucherCardTokenizationCompleteRequest request) {
        return cardTokenizationComplete(sessionId, request, null);
    }

    public MealVoucherCardTokenizationCompleteResponse cardTokenizationComplete(String sessionId, MealVoucherCardTokenizationCompleteRequest request, RequestContext requestContext) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/" + sessionId + "/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, MealVoucherCardTokenizationCompleteResponse.class);
    }
}