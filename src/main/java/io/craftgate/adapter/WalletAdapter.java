package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateRemittanceRequest;
import io.craftgate.request.SearchWalletTransactionsRequest;
import io.craftgate.request.SearchWalletsRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.RemittanceResponse;
import io.craftgate.response.WalletListResponse;
import io.craftgate.response.WalletTransactionListResponse;

public class WalletAdapter extends BaseAdapter {

    public WalletAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public WalletListResponse searchWallets(SearchWalletsRequest searchWalletsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchWalletsRequest);
        String path = "/wallet/v1/wallets" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletListResponse.class);
    }

    public WalletTransactionListResponse searchWalletTransactions(Long walletId, SearchWalletTransactionsRequest searchWalletTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchWalletTransactionsRequest);
        String path = "/wallet/v1/wallets/" + walletId + "/wallet-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletTransactionListResponse.class);
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
