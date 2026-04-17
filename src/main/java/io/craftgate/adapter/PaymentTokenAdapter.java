package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.PaymentTokenResponse;

public class PaymentTokenAdapter extends BaseAdapter {

    public PaymentTokenAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentTokenResponse createPaymentToken(CreatePaymentTokenRequest createPaymentTokenRequest) {
        return createPaymentToken(createPaymentTokenRequest, null);
    }

    public PaymentTokenResponse createPaymentToken(CreatePaymentTokenRequest createPaymentTokenRequest, RequestContext requestContext) {
        String path = "/payment/v1/payment-tokens";
        return HttpClient.post(requestOptions.getBaseUrl() + path,
                createHeaders(createPaymentTokenRequest, path, requestContext),
                createPaymentTokenRequest,
                PaymentTokenResponse.class);
    }

    public void deletePaymentToken(String token) {
        deletePaymentToken(token, null);
    }

    public void deletePaymentToken(String token, RequestContext requestContext) {
        String path = "/payment/v1/payment-tokens/" + token;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext));
    }
}
