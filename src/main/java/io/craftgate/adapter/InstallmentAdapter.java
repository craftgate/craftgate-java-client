package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.SearchInstallmentsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.BinNumberResponse;
import io.craftgate.response.InstallmentListResponse;

public class InstallmentAdapter extends BaseAdapter {

    public InstallmentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InstallmentListResponse searchInstallments(SearchInstallmentsRequest searchInstallmentsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchInstallmentsRequest);
        String path = "/installment/v1/installments" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), InstallmentListResponse.class);
    }

    public BinNumberResponse retrieveBinNumber(String binNumber) {
        return retrieveBinNumber(binNumber, false);
    }

    public BinNumberResponse retrieveBinNumber(String binNumber, boolean includeGlobalBins) {
        String path = "/installment/v1/bins/" + binNumber + (includeGlobalBins ? "?includeGlobalBins=true" : "");
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BinNumberResponse.class);
    }
}
