package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.*;

public class JuzdanPaymentAdapter extends BaseAdapter {

    public JuzdanPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InitJuzdanPaymentResponse init(InitJuzdanPaymentRequest initJuzdanPaymentRequest) {
        String path = "/payment/v1/juzdan-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initJuzdanPaymentRequest, path, requestOptions),
                initJuzdanPaymentRequest, InitJuzdanPaymentResponse.class);
    }

    public PaymentResponse retrieve(String referenceId) {
        String path = "/payment/v1/juzdan-payments/" + referenceId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }

}