package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateRemittanceRequest;
import io.craftgate.request.SearchWalletRequest;
import io.craftgate.request.SearchWalletTxRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.RemittanceResponse;
import io.craftgate.response.WalletListResponse;
import io.craftgate.response.WalletTxListResponse;

public class WalletAdapter extends BaseAdapter {

    public WalletAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public WalletListResponse searchWallets(SearchWalletRequest searchWalletRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchWalletRequest);
        String path = "/wallet/v1/wallets" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletListResponse.class);
    }

    public WalletTxListResponse searchWalletTransactions(Long walletId, SearchWalletTxRequest searchWalletRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchWalletRequest);
        String path = "/wallet/v1/wallets/" + walletId + "/wallet-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletTxListResponse.class);
    }

    public RemittanceResponse sendRemittance(CreateRemittanceRequest createRemittanceRequest) {
        String path = "/wallet/v1/remittances/send";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createRemittanceRequest, path, requestOptions),
                createRemittanceRequest, RemittanceResponse.class);
    }

    public RemittanceResponse receiveRemittance(CreateRemittanceRequest createRemittanceRequest) {
        String path = "/wallet/v1/remittances/receive";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createRemittanceRequest, path, requestOptions),
                createRemittanceRequest, RemittanceResponse.class);
    }
}
