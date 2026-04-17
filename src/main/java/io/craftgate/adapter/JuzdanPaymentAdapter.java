package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.InitJuzdanPaymentRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.InitJuzdanPaymentResponse;
import io.craftgate.response.PaymentResponse;

public class JuzdanPaymentAdapter extends BaseAdapter {

    public JuzdanPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InitJuzdanPaymentResponse init(InitJuzdanPaymentRequest initJuzdanPaymentRequest) {
        return init(initJuzdanPaymentRequest, null);
    }

    public InitJuzdanPaymentResponse init(InitJuzdanPaymentRequest initJuzdanPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/juzdan-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initJuzdanPaymentRequest, path, requestContext),
                initJuzdanPaymentRequest, InitJuzdanPaymentResponse.class);
    }

    public PaymentResponse retrieve(String referenceId) {
        String path = "/payment/v1/juzdan-payments/" + referenceId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentResponse.class);
    }
}
