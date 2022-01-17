package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

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

    public InitGarantiPayPaymentResponse initGarantiPayPayment(InitGarantiPayPaymentRequest initGarantiPayPaymentRequest) {
        String path = "/payment/v1/garanti-pay-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initGarantiPayPaymentRequest, path, requestOptions),
                initGarantiPayPaymentRequest, InitGarantiPayPaymentResponse.class);
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
        String query = RequestQueryParamsBuilder.buildQueryParam(deleteStoredCardRequest);
        String path = "/payment/v1/cards" + query;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
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

    public CheckMasterpassUserResponse checkMasterpassUser(CheckMasterpassUserRequest checkMasterpassUserRequest) {
        String path = "/payment/v1/masterpass-payments/check-user";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(checkMasterpassUserRequest, path, requestOptions),
                checkMasterpassUserRequest, CheckMasterpassUserResponse.class);
    }
}
