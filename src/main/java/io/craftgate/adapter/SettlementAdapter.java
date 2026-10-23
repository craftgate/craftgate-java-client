package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.SettlementResponse;

public class SettlementAdapter extends BaseAdapter {

    public SettlementAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public SettlementResponse createInstantWalletSettlement(CreateInstantWalletSettlementRequest request) {
        String path = "/settlement/v1/instant-wallet-settlements";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, SettlementResponse.class);
    }
}
