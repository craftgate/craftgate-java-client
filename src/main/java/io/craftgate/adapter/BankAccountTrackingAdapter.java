package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchBankAccountTrackingRecordsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.BankAccountTrackingRecordListResponse;
import io.craftgate.response.BankAccountTrackingRecordResponse;

public class BankAccountTrackingAdapter extends BaseAdapter {

    public BankAccountTrackingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public BankAccountTrackingRecordListResponse searchRecords(SearchBankAccountTrackingRecordsRequest request) {
        String query = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/bank-account-tracking/v1/merchant-bank-account-trackings/records" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BankAccountTrackingRecordListResponse.class);
    }

    public BankAccountTrackingRecordResponse retrieveRecord(Long id) {
        String path = "/bank-account-tracking/v1/merchant-bank-account-trackings/records/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BankAccountTrackingRecordResponse.class);
    }
}