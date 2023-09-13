package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.CheckMasterpassUserResponse;
import io.craftgate.response.MasterpassPaymentThreeDSInitResponse;
import io.craftgate.response.MasterpassPaymentTokenGenerateResponse;
import io.craftgate.response.PaymentResponse;

public class MasterpassPaymentAdapter extends BaseAdapter {

    public MasterpassPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public CheckMasterpassUserResponse checkMasterpassUser(CheckMasterpassUserRequest checkMasterpassUserRequest) {
        String path = "/payment/v1/masterpass-payments/check-user";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(checkMasterpassUserRequest, path, requestOptions),
                checkMasterpassUserRequest, CheckMasterpassUserResponse.class);
    }

    public MasterpassPaymentTokenGenerateResponse generateMasterpassPaymentToken(MasterpassPaymentTokenGenerateRequest masterpassPaymentTokenGenerateRequest) {
        String path = "/payment/v2/masterpass-payments/generate-token";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentTokenGenerateRequest, path, requestOptions),
                masterpassPaymentTokenGenerateRequest, MasterpassPaymentTokenGenerateResponse.class);
    }

    public PaymentResponse completeMasterpassPayment(MasterpassPaymentCompleteRequest masterpassPaymentCompleteRequest) {
        String path = "/payment/v2/masterpass-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentCompleteRequest, path, requestOptions),
                masterpassPaymentCompleteRequest, PaymentResponse.class);
    }

    public MasterpassPaymentThreeDSInitResponse init3DSMasterpassPayment(MasterpassPaymentThreeDSInitRequest masterpassPaymentThreeDSInitRequest) {
        String path = "/payment/v2/masterpass-payments/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentThreeDSInitRequest, path, requestOptions),
                masterpassPaymentThreeDSInitRequest, MasterpassPaymentThreeDSInitResponse.class);
    }

    public PaymentResponse complete3DSMasterpassPayment(MasterpassPaymentThreeDSCompleteRequest masterpassPaymentThreeDSCompleteRequest) {
        String path = "/payment/v2/masterpass-payments/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentThreeDSCompleteRequest, path, requestOptions),
                masterpassPaymentThreeDSCompleteRequest, PaymentResponse.class);
    }
}