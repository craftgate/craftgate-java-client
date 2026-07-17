package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.*;

public class BkmExpressPaymentAdapter extends BaseAdapter {

    public BkmExpressPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    private BkmExpressPaymentAdapter(RequestOptions requestOptions, RequestContext requestContext) {
        super(requestOptions, requestContext);
    }

    public BkmExpressPaymentAdapter withRequestContext(RequestContext requestContext) {
        return new BkmExpressPaymentAdapter(requestOptions, requestContext);
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

    public PaymentResponse retrievePaymentByToken(String token) {
        String path = "/payment/v1/bkm-express/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }
}