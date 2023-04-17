package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.SearchSettlementRowsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.SettlementResponse;
import io.craftgate.response.SettlementRowListResponse;
import io.craftgate.response.StoredCardListResponse;

public class SettlementAdapter extends BaseAdapter {

    public SettlementAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public SettlementResponse createInstantWalletSettlement(CreateInstantWalletSettlementRequest request) {
        String path = "/settlement/v1/instant-wallet-settlements";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, SettlementResponse.class);
    }

    public SettlementRowListResponse searchSettlementRows(SearchSettlementRowsRequest request) {
        String queryParam = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/settlement/v1/settlements/rows" + queryParam;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), SettlementRowListResponse.class);
    }
}
