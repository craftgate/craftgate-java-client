package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.*;

public class BkmExpressPaymentAdapter extends BaseAdapter {

    public BkmExpressPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public BkmExpressGenerateTokenResponse generateToken(BkmExpressGenerateTokenRequest bkmExpressGenerateTokenRequest) {
        String path = "/payment/v2/bkm-express/generate-token";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(bkmExpressGenerateTokenRequest, path, requestOptions),
                bkmExpressGenerateTokenRequest, BkmExpressGenerateTokenResponse.class);
    }
}
