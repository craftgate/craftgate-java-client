package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;

public class MealVoucherCardTokenizationAdapter extends BaseAdapter {

    public MealVoucherCardTokenizationAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    private MealVoucherCardTokenizationAdapter(RequestOptions requestOptions, RequestContext requestContext) {
        super(requestOptions, requestContext);
    }

    public MealVoucherCardTokenizationAdapter withRequestContext(RequestContext requestContext) {
        return new MealVoucherCardTokenizationAdapter(requestOptions, requestContext);
    }

    public MealVoucherCardTokenizationInitResponse cardTokenizationInit(MealVoucherCardTokenizationInitRequest mealVoucherCardTokenizationInitRequest) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationInitRequest, path, requestOptions),
                mealVoucherCardTokenizationInitRequest, MealVoucherCardTokenizationInitResponse.class);
    }
}