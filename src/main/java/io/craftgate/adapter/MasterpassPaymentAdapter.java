package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.*;

public class MasterpassPaymentAdapter extends BaseAdapter {

    public MasterpassPaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public CheckMasterpassUserResponse checkMasterpassUser(CheckMasterpassUserRequest checkMasterpassUserRequest) {
        return checkMasterpassUser(checkMasterpassUserRequest, null);
    }

    public CheckMasterpassUserResponse checkMasterpassUser(CheckMasterpassUserRequest checkMasterpassUserRequest, RequestContext requestContext) {
        String path = "/payment/v1/masterpass-payments/check-user";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(checkMasterpassUserRequest, path, requestContext),
                checkMasterpassUserRequest, CheckMasterpassUserResponse.class);
    }

    public MasterpassPaymentTokenGenerateResponse generateMasterpassPaymentToken(MasterpassPaymentTokenGenerateRequest masterpassPaymentTokenGenerateRequest) {
        return generateMasterpassPaymentToken(masterpassPaymentTokenGenerateRequest, null);
    }

    public MasterpassPaymentTokenGenerateResponse generateMasterpassPaymentToken(MasterpassPaymentTokenGenerateRequest masterpassPaymentTokenGenerateRequest, RequestContext requestContext) {
        String path = "/payment/v2/masterpass-payments/generate-token";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentTokenGenerateRequest, path, requestContext),
                masterpassPaymentTokenGenerateRequest, MasterpassPaymentTokenGenerateResponse.class);
    }

    public PaymentResponse completeMasterpassPayment(MasterpassPaymentCompleteRequest masterpassPaymentCompleteRequest) {
        return completeMasterpassPayment(masterpassPaymentCompleteRequest, null);
    }

    public PaymentResponse completeMasterpassPayment(MasterpassPaymentCompleteRequest masterpassPaymentCompleteRequest, RequestContext requestContext) {
        String path = "/payment/v2/masterpass-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentCompleteRequest, path, requestContext),
                masterpassPaymentCompleteRequest, PaymentResponse.class);
    }

    public MasterpassPaymentThreeDSInitResponse init3DSMasterpassPayment(MasterpassPaymentThreeDSInitRequest masterpassPaymentThreeDSInitRequest) {
        return init3DSMasterpassPayment(masterpassPaymentThreeDSInitRequest, null);
    }

    public MasterpassPaymentThreeDSInitResponse init3DSMasterpassPayment(MasterpassPaymentThreeDSInitRequest masterpassPaymentThreeDSInitRequest, RequestContext requestContext) {
        String path = "/payment/v2/masterpass-payments/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentThreeDSInitRequest, path, requestContext),
                masterpassPaymentThreeDSInitRequest, MasterpassPaymentThreeDSInitResponse.class);
    }

    public PaymentResponse complete3DSMasterpassPayment(MasterpassPaymentThreeDSCompleteRequest masterpassPaymentThreeDSCompleteRequest) {
        return complete3DSMasterpassPayment(masterpassPaymentThreeDSCompleteRequest, null);
    }

    public PaymentResponse complete3DSMasterpassPayment(MasterpassPaymentThreeDSCompleteRequest masterpassPaymentThreeDSCompleteRequest, RequestContext requestContext) {
        String path = "/payment/v2/masterpass-payments/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassPaymentThreeDSCompleteRequest, path, requestContext),
                masterpassPaymentThreeDSCompleteRequest, PaymentResponse.class);
    }

    public RetrieveLoyaltiesResponse retrieveLoyalties(MasterpassRetrieveLoyaltiesRequest masterpassRetrieveLoyaltiesRequest) {
        return retrieveLoyalties(masterpassRetrieveLoyaltiesRequest, null);
    }

    public RetrieveLoyaltiesResponse retrieveLoyalties(MasterpassRetrieveLoyaltiesRequest masterpassRetrieveLoyaltiesRequest, RequestContext requestContext) {
        String path = "/payment/v2/masterpass-payments/loyalties/retrieve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(masterpassRetrieveLoyaltiesRequest, path, requestContext),
                masterpassRetrieveLoyaltiesRequest, RetrieveLoyaltiesResponse.class);
    }
}
