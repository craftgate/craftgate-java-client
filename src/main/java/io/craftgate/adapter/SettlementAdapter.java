package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.CreatePayoutAccountRequest;
import io.craftgate.request.SearchPayoutAccountRequest;
import io.craftgate.request.UpdatePayoutAccountRequest;
import io.craftgate.request.common.RequestContext;
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
        return createInstantWalletSettlement(request, null);
    }

    public SettlementResponse createInstantWalletSettlement(CreateInstantWalletSettlementRequest request, RequestContext requestContext) {
        String path = "/settlement/v1/instant-wallet-settlements";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, SettlementResponse.class);
    }

    public PayoutAccountResponse createPayoutAccount(CreatePayoutAccountRequest request) {
        return createPayoutAccount(request, null);
    }

    public PayoutAccountResponse createPayoutAccount(CreatePayoutAccountRequest request, RequestContext requestContext) {
        String path = "/settlement/v1/payout-accounts";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, PayoutAccountResponse.class);
    }

    public void updatePayoutAccount(Long id, UpdatePayoutAccountRequest request) {
        String path = "/settlement/v1/payout-accounts/" + id;
        HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(request, path),
                request, Void.class);
    }

    public void deletePayoutAccount(Long id) {
        deletePayoutAccount(id, null);
    }

    public void deletePayoutAccount(Long id, RequestContext requestContext) {
        String path = "/settlement/v1/payout-accounts/" + id;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext));
    }

    public PayoutAccountListResponse searchPayoutAccount(SearchPayoutAccountRequest request) {
        String query = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/settlement/v1/payout-accounts" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PayoutAccountListResponse.class);
    }
}
