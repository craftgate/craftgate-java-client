package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.BnplPaymentOfferRequest;
import io.craftgate.request.MasterpassPaymentTokenGenerateRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.BnplPaymentOfferResponse;
import io.craftgate.response.MasterpassPaymentTokenGenerateResponse;
import io.craftgate.response.PaymentResponse;

public class BnplPaymentAdapter extends BaseAdapter {

    public BnplPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public BnplPaymentOfferResponse offer(BnplPaymentOfferRequest bnplPaymentOfferRequest) {
        String path = "/payment/v1/bnpl-payments/offers";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(bnplPaymentOfferRequest, path, requestOptions),
                bnplPaymentOfferRequest, BnplPaymentOfferResponse.class);
    }

    public MasterpassPaymentTokenGenerateResponse init(MasterpassPaymentTokenGenerateRequest masterpassPaymentTokenGenerateRequest) {
        String path = "/payment/v1/bnpl-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentTokenGenerateRequest, path, requestOptions),
                masterpassPaymentTokenGenerateRequest, MasterpassPaymentTokenGenerateResponse.class);
    }

    public PaymentResponse approve(Long paymentId) {
        String path = "/payment/v1/bnpl-payments/" + paymentId + "/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }
}