package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchPayoutBouncedTransactionsRequest;
import io.craftgate.request.SearchPayoutCompletedTransactionsRequest;
import io.craftgate.request.SearchPayoutRowsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.PayoutBouncedTransactionListResponse;
import io.craftgate.response.PayoutCompletedTransactionListResponse;
import io.craftgate.response.PayoutDetailResponse;
import io.craftgate.response.PayoutRowListResponse;

public class SettlementReportingAdapter extends BaseAdapter {

    public SettlementReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PayoutCompletedTransactionListResponse searchPayoutCompletedTransactions(SearchPayoutCompletedTransactionsRequest searchPayoutCompletedTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPayoutCompletedTransactionsRequest);
        String path = "/settlement-reporting/v1/settlement-file/payout-completed-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutCompletedTransactionListResponse.class);
    }

    public PayoutBouncedTransactionListResponse searchBouncedPayoutTransactions(SearchPayoutBouncedTransactionsRequest searchPayoutBouncedTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPayoutBouncedTransactionsRequest);
        String path = "/settlement-reporting/v1/settlement-file/bounced-sub-merchant-rows" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutBouncedTransactionListResponse.class);
    }

    public PayoutDetailResponse retrievePayoutDetails(Long id) {
        String path = "/settlement-reporting/v1/settlement-file/payout-details/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutDetailResponse.class);
    }

    public PayoutRowListResponse searchPayoutRows(SearchPayoutRowsRequest request) {
        String queryParam = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/settlement/v1/settlements/rows" + queryParam;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutRowListResponse.class);
    }
}
