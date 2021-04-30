package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchPaymentsRequest;
import io.craftgate.request.SearchRefundTransactionsRequest;
import io.craftgate.request.SearchRefundsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

public class PaymentReportingAdapter extends BaseAdapter {

    public PaymentReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentReportingListResponse searchPayments(SearchPaymentsRequest searchPaymentsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentsRequest);
        String path = "/payment-reporting/v1/payments" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentReportingListResponse.class);
    }

    public PaymentReportingResponse retrievePayment(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentReportingResponse.class);
    }

    public PaymentTransactionListResponse retrievePaymentTransactions(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/transactions";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionListResponse.class);
    }

    public PaymentRefundReportingListResponse retrievePaymentRefunds(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentRefundReportingListResponse.class);
    }

    public PaymentTransactionRefundReportingListResponse retrievePaymentTransactionRefunds(Long paymentId, Long paymentTransactionId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/transactions/" + paymentTransactionId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundReportingListResponse.class);
    }

    public PaymentRefundSearchListResponse searchPaymentRefunds(SearchRefundsRequest searchRefundsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchRefundsRequest);
        String path = "/payment-reporting/v1/refunds" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentRefundSearchListResponse.class);
    }

    public PaymentTransactionRefundSearchListResponse searchPaymentTransactionRefunds(SearchRefundTransactionsRequest searchRefundTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchRefundTransactionsRequest);
        String path = "/payment-reporting/v1/refund-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundSearchListResponse.class);
    }
}
