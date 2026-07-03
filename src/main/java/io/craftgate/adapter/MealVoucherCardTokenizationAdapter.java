package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;

public class MealVoucherCardTokenizationAdapter extends BaseAdapter {

    public MealVoucherCardTokenizationAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MealVoucherCardTokenizationInitResponse cardTokenizationInit(MealVoucherCardTokenizationInitRequest mealVoucherCardTokenizationInitRequest) {
        String path = "/payment/v1/meal-voucher/card-tokenizations/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(mealVoucherCardTokenizationInitRequest, path, requestOptions),
                mealVoucherCardTokenizationInitRequest, MealVoucherCardTokenizationInitResponse.class);
    }
}