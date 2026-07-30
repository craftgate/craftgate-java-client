package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.request.DeletePaymentTokenRequest;
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

    public void deletePaymentToken(DeletePaymentTokenRequest deletePaymentTokenRequest) {
        String path = "/payment/v1/payment-tokens/" + deletePaymentTokenRequest.getToken();
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeadersWithoutBody(path, requestOptions, deletePaymentTokenRequest));
    }
}
