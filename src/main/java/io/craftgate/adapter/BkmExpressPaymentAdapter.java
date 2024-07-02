package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.*;

public class BkmExpressPaymentAdapter extends BaseAdapter {

    public BkmExpressPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InitBkmExpressResponse init(InitBkmExpressRequest initBkmExpressRequest) {
        String path = "/payment/v1/bkm-express/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initBkmExpressRequest, path, requestOptions),
                initBkmExpressRequest, InitBkmExpressResponse.class);
    }

    public PaymentResponse complete(CompleteBkmExpressRequest completeRequest) {
        String path = "/payment/v1/bkm-express/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeRequest, path, requestOptions),
                completeRequest, PaymentResponse.class);
    }

    public PaymentResponse retrievePayment(String ticketId) {
        String path = "/payment/v1/bkm-express/payments/" + ticketId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }
}