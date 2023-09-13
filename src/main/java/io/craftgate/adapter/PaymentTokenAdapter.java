package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.PaymentTokenResponse;

public class PaymentTokenAdapter extends BaseAdapter {

    public PaymentTokenAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentTokenResponse createPaymentToken(CreatePaymentTokenRequest createPaymentTokenRequest) {
        String path = "/payment/v1/payment-tokens";
        return HttpClient.post(requestOptions.getBaseUrl() + path,
                createHeaders(createPaymentTokenRequest, path, requestOptions),
                createPaymentTokenRequest,
                PaymentTokenResponse.class);
    }

    public void deletePaymentToken(String token) {
        String path = "/payment/v1/payment-tokens/" + token;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }
}
