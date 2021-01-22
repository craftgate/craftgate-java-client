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

    public InitCheckoutPaymentResponse initCheckoutPayment(InitCheckoutPaymentRequest initCheckoutPaymentRequest) {
        String path = "/payment/v1/checkout-payment/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initCheckoutPaymentRequest, path, requestOptions),
                initCheckoutPaymentRequest, InitCheckoutPaymentResponse.class);
    }

    public PaymentResponse retrieveCheckoutPayment(String token) {
        String path = "/payment/v1/checkout-payment?token=" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }

    public DepositPaymentResponse createDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest) {
        String path = "/payment/v1/deposits";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositPaymentRequest, path, requestOptions),
                createDepositPaymentRequest, DepositPaymentResponse.class);
    }

    public DepositPaymentRefundResponse refundDepositPayment(Long paymentId, RefundDepositPaymentRequest refundDepositPaymentRequest) {
        String path = "/payment/v1/deposits/" + paymentId + "/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundDepositPaymentRequest, path, requestOptions),
                refundDepositPaymentRequest, DepositPaymentRefundResponse.class);
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

    public PaymentTransactionRefundResponse refundPaymentTransaction(RefundPaymentTransactionRequest refundPaymentTransactionRequest) {
        String path = "/payment/v1/refund-transactions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentTransactionRequest, path, requestOptions),
                refundPaymentTransactionRequest, PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundResponse retrievePaymentTransactionRefund(Long id) {
        String path = "/payment/v1/refund-transactions/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundListResponse searchPaymentTransactionRefunds(SearchPaymentTransactionRefundsRequest searchPaymentTransactionRefundsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentTransactionRefundsRequest);
        String path = "/payment/v1/refund-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundListResponse.class);
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
}
