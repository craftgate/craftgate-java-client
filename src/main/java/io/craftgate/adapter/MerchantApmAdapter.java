package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MerchantApmListResponse;

public class MerchantApmAdapter extends BaseAdapter {

    public MerchantApmAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MerchantApmListResponse retrieveApms() {
        String path = "/merchant/v1/merchant-apms";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), MerchantApmListResponse.class);
    }

}