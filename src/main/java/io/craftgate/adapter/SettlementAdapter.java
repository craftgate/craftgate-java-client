package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.CreatePayoutAccountRequest;
import io.craftgate.request.SearchPayoutAccountRequest;
import io.craftgate.request.UpdatePayoutAccountRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.PayoutAccountListResponse;
import io.craftgate.response.PayoutAccountResponse;
import io.craftgate.response.SettlementResponse;

public class SettlementAdapter extends BaseAdapter {

    public SettlementAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public SettlementResponse createInstantWalletSettlement(CreateInstantWalletSettlementRequest request) {
        String path = "/settlement/v1/instant-wallet-settlements";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, SettlementResponse.class);
    }

    public PayoutAccountResponse createPayoutAccount(CreatePayoutAccountRequest request) {
        String path = "/settlement/v1/payout-accounts";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, PayoutAccountResponse.class);
    }

    public void updatePayoutAccount(Long id, UpdatePayoutAccountRequest request) {
        String path = "/settlement/v1/payout-accounts/" + id;
        HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, Void.class);
    }

    public void deletePayoutAccount(Long id) {
        String path = "/settlement/v1/payout-accounts/" + id;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }

    public PayoutAccountListResponse searchPayoutAccount(SearchPayoutAccountRequest request) {
        String query = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/settlement/v1/payout-accounts" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutAccountListResponse.class);
    }
}
