package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchPaymentTransactionPayoutsRequest;
import io.craftgate.request.SearchPayoutBouncedTransactionsRequest;
import io.craftgate.request.SearchPayoutCompletedItemsRequest;
import io.craftgate.request.SearchPayoutRowsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.PaymentTxPayoutListResponse;
import io.craftgate.response.PaymentTxPayoutResponse;
import io.craftgate.response.PayoutBouncedTransactionListResponse;
import io.craftgate.response.PayoutCompletedItemListResponse;
import io.craftgate.response.PayoutRowListResponse;
import io.craftgate.response.SettlementRowResponse;

public class SettlementReportingAdapter extends BaseAdapter {

    public SettlementReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PayoutCompletedItemListResponse searchPayoutCompletedItems(SearchPayoutCompletedItemsRequest searchPayoutCompletedItemsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPayoutCompletedItemsRequest);
        String path = "/settlement-reporting/v1/settlement-file/payout-completed-items" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeadersWithoutBody(searchPayoutCompletedItemsRequest, path, requestOptions), PayoutCompletedItemListResponse.class);
    }

    public PayoutBouncedTransactionListResponse searchBouncedPayoutTransactions(SearchPayoutBouncedTransactionsRequest searchPayoutBouncedTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPayoutBouncedTransactionsRequest);
        String path = "/settlement-reporting/v1/settlement-file/bounced-sub-merchant-rows" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeadersWithoutBody(searchPayoutBouncedTransactionsRequest, path, requestOptions), PayoutBouncedTransactionListResponse.class);
    }

    public SettlementRowResponse retrieveSettlementRow(Long settlementRowId) {
        String path = "/settlement-reporting/v1/settlement-file/rows/" + settlementRowId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), SettlementRowResponse.class);
    }

    public PayoutRowListResponse searchPayoutRows(SearchPayoutRowsRequest request) {
        String queryParam = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/settlement-reporting/v1/settlement-file-rows" + queryParam;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeadersWithoutBody(request, path, requestOptions), PayoutRowListResponse.class);
    }

    public PaymentTxPayoutResponse retrievePaymentTransactionPayout(Long paymentTransactionId) {
        String path = "/settlement-reporting/v1/payment-transactions/" + paymentTransactionId + "/payout";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTxPayoutResponse.class);
    }

    public PaymentTxPayoutListResponse searchPaymentTransactionPayouts(SearchPaymentTransactionPayoutsRequest searchPaymentTransactionPayoutsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentTransactionPayoutsRequest);
        String path = "/settlement-reporting/v1/payment-transactions/payouts" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeadersWithoutBody(searchPaymentTransactionPayoutsRequest, path, requestOptions), PaymentTxPayoutListResponse.class);
    }
}
