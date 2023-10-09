package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

import java.util.Map;

public class PaymentAdapter extends BaseAdapter {

    public PaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {
        String path = "/payment/v1/card-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createPaymentRequest, path, requestOptions),
                createPaymentRequest, PaymentResponse.class);
    }

    public PaymentResponse retrievePayment(Long id) {
        String path = "/payment/v1/card-payments/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }

    public InitThreeDSPaymentResponse init3DSPayment(InitThreeDSPaymentRequest initThreeDSPaymentRequest) {
        String path = "/payment/v1/card-payments/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initThreeDSPaymentRequest, path, requestOptions),
                initThreeDSPaymentRequest, InitThreeDSPaymentResponse.class);
    }

    public PaymentResponse complete3DSPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest) {
        String path = "/payment/v1/card-payments/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeThreeDSPaymentRequest, path, requestOptions),
                completeThreeDSPaymentRequest, PaymentResponse.class);
    }

    public PaymentResponse postAuthPayment(long paymentId, PostAuthPaymentRequest postAuthPaymentRequest) {
        String path = "/payment/v1/card-payments/" + paymentId + "/post-auth";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(postAuthPaymentRequest, path, requestOptions),
                postAuthPaymentRequest, PaymentResponse.class);
    }

    public InitCheckoutPaymentResponse initCheckoutPayment(InitCheckoutPaymentRequest initCheckoutPaymentRequest) {
        String path = "/payment/v1/checkout-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initCheckoutPaymentRequest, path, requestOptions),
                initCheckoutPaymentRequest, InitCheckoutPaymentResponse.class);
    }

    public PaymentResponse retrieveCheckoutPayment(String token) {
        String path = "/payment/v1/checkout-payments/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }

    public void expireCheckoutPayment(String token) {
        String path = "/payment/v1/checkout-payments/" + token;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }

    public DepositPaymentResponse createDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest) {
        String path = "/payment/v1/deposits";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositPaymentRequest, path, requestOptions),
                createDepositPaymentRequest, DepositPaymentResponse.class);
    }

    public InitThreeDSPaymentResponse init3DSDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest) {
        String path = "/payment/v1/deposits/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositPaymentRequest, path, requestOptions),
                createDepositPaymentRequest, InitThreeDSPaymentResponse.class);
    }

    public DepositPaymentResponse complete3DSDepositPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest) {
        String path = "/payment/v1/deposits/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeThreeDSPaymentRequest, path, requestOptions),
                completeThreeDSPaymentRequest, DepositPaymentResponse.class);
    }

    public FundTransferDepositPaymentResponse createFundTransferDepositPayment(CreateFundTransferDepositPaymentRequest createFundTransferDepositPaymentRequest) {
        String path = "/payment/v1/deposits/fund-transfer";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createFundTransferDepositPaymentRequest, path, requestOptions),
                createFundTransferDepositPaymentRequest, FundTransferDepositPaymentResponse.class);
    }

    public ApmDepositPaymentResponse initApmDepositPayment(InitApmDepositPaymentRequest initApmDepositPaymentRequest) {
        String path = "/payment/v1/deposits/apm-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initApmDepositPaymentRequest, path, requestOptions),
                initApmDepositPaymentRequest, ApmDepositPaymentResponse.class);
    }

    public InitGarantiPayPaymentResponse initGarantiPayPayment(InitGarantiPayPaymentRequest initGarantiPayPaymentRequest) {
        String path = "/payment/v1/garanti-pay-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initGarantiPayPaymentRequest, path, requestOptions),
                initGarantiPayPaymentRequest, InitGarantiPayPaymentResponse.class);
    }

    public ApmPaymentInitResponse initApmPayment(InitApmPaymentRequest request) {
        String path = "/payment/v1/apm-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, ApmPaymentInitResponse.class);
    }

    public ApmPaymentCompleteResponse completeApmPayment(CompleteApmPaymentRequest request) {
        String path = "/payment/v1/apm-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, ApmPaymentCompleteResponse.class);
    }

    public PaymentResponse createApmPayment(CreateApmPaymentRequest request) {
        String path = "/payment/v1/apm-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, PaymentResponse.class);
    }

    public InitPosApmPaymentResponse initPosApmPayment(InitPosApmPaymentRequest request) {
        String path = "/payment/v1/pos-apm-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, InitPosApmPaymentResponse.class);
    }

    public PaymentResponse completePosApmPayment(CompletePosApmPaymentRequest request) {
        String path = "/payment/v1/pos-apm-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, PaymentResponse.class);
    }

    public RetrieveLoyaltiesResponse retrieveLoyalties(RetrieveLoyaltiesRequest retrieveLoyaltiesRequest) {
        String path = "/payment/v1/card-loyalties/retrieve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(retrieveLoyaltiesRequest, path, requestOptions),
                retrieveLoyaltiesRequest, RetrieveLoyaltiesResponse.class);
    }

    public PaymentTransactionRefundResponse refundPaymentTransaction(RefundPaymentTransactionRequest refundPaymentTransactionRequest) {
        String path = "/payment/v1/refund-transactions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentTransactionRequest, path, requestOptions),
                refundPaymentTransactionRequest, PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundResponse retrievePaymentTransactionRefund(Long id) {
        String path = "/payment/v1/refund-transactions/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundResponse.class);
    }

    public PaymentRefundResponse refundPayment(RefundPaymentRequest refundPaymentRequest) {
        String path = "/payment/v1/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentRequest, path, requestOptions),
                refundPaymentRequest, PaymentRefundResponse.class);
    }

    public PaymentRefundResponse retrievePaymentRefund(Long id) {
        String path = "/payment/v1/refunds/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentRefundResponse.class);
    }

    public StoredCardResponse storeCard(StoreCardRequest storeCardRequest) {
        String path = "/payment/v1/cards";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(storeCardRequest, path, requestOptions),
                storeCardRequest, StoredCardResponse.class);
    }

    public StoredCardResponse updateCard(UpdateCardRequest updateCardRequest) {
        String path = "/payment/v1/cards/update";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(updateCardRequest, path, requestOptions),
                updateCardRequest, StoredCardResponse.class);
    }

    public StoredCardListResponse searchStoredCards(SearchStoredCardsRequest searchStoredCardsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchStoredCardsRequest);
        String path = "/payment/v1/cards" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), StoredCardListResponse.class);
    }

    public void deleteStoredCard(DeleteStoredCardRequest deleteStoredCardRequest) {
        String path = "/payment/v1/cards/delete";
        HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(deleteStoredCardRequest, path, requestOptions),
                deleteStoredCardRequest, Void.class);
    }

    public PaymentTransactionApprovalListResponse approvePaymentTransactions(ApprovePaymentTransactionsRequest approvePaymentTransactionsRequest) {
        String path = "/payment/v1/payment-transactions/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(approvePaymentTransactionsRequest, path, requestOptions),
                approvePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionApprovalListResponse disapprovePaymentTransactions(DisapprovePaymentTransactionsRequest disapprovePaymentTransactionsRequest) {
        String path = "/payment/v1/payment-transactions/disapprove";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(disapprovePaymentTransactionsRequest, path, requestOptions),
                disapprovePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionResponse updatePaymentTransaction(UpdatePaymentTransactionRequest updatePaymentTransactionRequest) {
        String path = "/payment/v1/payment-transactions/" + updatePaymentTransactionRequest.getPaymentTransactionId();
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updatePaymentTransactionRequest, path, requestOptions),
                updatePaymentTransactionRequest, PaymentTransactionResponse.class);
    }

    public boolean is3DSecureCallbackVerified(String threeDSecureCallbackKey, Map<String, String> params) {
        String hash = params.get("hash");
        String hashString = new StringBuilder(threeDSecureCallbackKey)
                .append("###")
                .append(params.getOrDefault("status", ""))
                .append("###")
                .append(params.getOrDefault("completeStatus", ""))
                .append("###")
                .append(params.getOrDefault("paymentId", ""))
                .append("###")
                .append(params.getOrDefault("conversationData", ""))
                .append("###")
                .append(params.getOrDefault("conversationId", ""))
                .append("###")
                .append(params.getOrDefault("callbackStatus", ""))
                .toString();

        String hashedParams = HashGenerator.generateHash(hashString);
        return hash.equals(hashedParams);
    }
}