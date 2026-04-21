package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CompleteBkmExpressRequest;
import io.craftgate.request.InitBkmExpressRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.InitBkmExpressResponse;
import io.craftgate.response.PaymentResponse;

public class BkmExpressPaymentAdapter extends BaseAdapter {

    public BkmExpressPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InitBkmExpressResponse init(InitBkmExpressRequest initBkmExpressRequest) {
        return init(initBkmExpressRequest, null);
    }

    public InitBkmExpressResponse init(InitBkmExpressRequest initBkmExpressRequest, RequestContext requestContext) {
        String path = "/payment/v1/bkm-express/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initBkmExpressRequest, path, requestContext),
                initBkmExpressRequest, InitBkmExpressResponse.class);
    }

    public PaymentResponse complete(CompleteBkmExpressRequest completeRequest) {
        return complete(completeRequest, null);
    }

    public PaymentResponse complete(CompleteBkmExpressRequest completeRequest, RequestContext requestContext) {
        String path = "/payment/v1/bkm-express/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeRequest, path, requestContext),
                completeRequest, PaymentResponse.class);
    }

    public PaymentResponse retrievePayment(String ticketId) {
        String path = "/payment/v1/bkm-express/payments/" + ticketId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentResponse.class);
    }

    public PaymentResponse retrievePaymentByToken(String token) {
        String path = "/payment/v1/bkm-express/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentResponse.class);
    }
}
