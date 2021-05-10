package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchPaymentRefundsRequest;
import io.craftgate.request.SearchPaymentTransactionRefundsRequest;
import io.craftgate.request.SearchPaymentsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

public class PaymentReportingAdapter extends BaseAdapter {

    public PaymentReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public ReportingPaymentListResponse searchPayments(SearchPaymentsRequest searchPaymentsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentsRequest);
        String path = "/payment-reporting/v1/payments" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentListResponse.class);
    }

    public ReportingPaymentResponse retrievePayment(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentResponse.class);
    }

    public ReportingPaymentTransactionListResponse retrievePaymentTransactions(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/transactions";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentTransactionListResponse.class);
    }

    public ReportingPaymentRefundListResponse retrievePaymentRefunds(Long paymentId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentRefundListResponse.class);
    }

    public ReportingPaymentTransactionRefundListResponse retrievePaymentTransactionRefunds(Long paymentId, Long paymentTransactionId) {
        String path = "/payment-reporting/v1/payments/" + paymentId + "/transactions/" + paymentTransactionId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentTransactionRefundListResponse.class);
    }

    public ReportingPaymentRefundListResponse searchPaymentRefunds(SearchPaymentRefundsRequest searchPaymentRefundsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentRefundsRequest);
        String path = "/payment-reporting/v1/refunds" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentRefundListResponse.class);
    }

    public ReportingPaymentTransactionRefundListResponse searchPaymentTransactionRefunds(SearchPaymentTransactionRefundsRequest searchPaymentTransactionRefundsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentTransactionRefundsRequest);
        String path = "/payment-reporting/v1/refund-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ReportingPaymentTransactionRefundListResponse.class);
    }
}
