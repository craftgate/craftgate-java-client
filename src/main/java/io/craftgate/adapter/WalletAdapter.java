package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

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

    public WalletResponse retrieveMerchantMemberWallet() {
        String path = "/wallet/v1/merchants/me/wallet";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletResponse.class);
    }

    public WalletResponse resetMerchantMemberWalletBalance(ResetMerchantMemberWalletBalanceRequest request) {
        String path = "/wallet/v1/merchants/me/wallet/reset-balance";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, WalletResponse.class);
    }

    public WalletTransactionRefundableAmountResponse retrieveRefundableAmountOfWalletTransaction(Long walletTransactionId) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refundable-amount";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WalletTransactionRefundableAmountResponse.class);
    }

    public RefundWalletTransactionToCardResponse refundWalletTransactionToCard(Long walletTransactionId, RefundWalletTransactionToCardRequest request) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, RefundWalletTransactionToCardResponse.class);
    }

    public RefundWalletTransactionToCardListResponse retrieveRefundWalletTransactionsToCard(Long walletTransactionId) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), RefundWalletTransactionToCardListResponse.class);
    }

    public WithdrawResponse createWithdraw(CreateWithdrawRequest request) {
        String path = "/wallet/v1/withdraws";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, WithdrawResponse.class);
    }

    public WithdrawResponse cancelWithdraw(Long withdrawId) {
        String path = "/wallet/v1/withdraws/" + withdrawId + "/cancel";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WithdrawResponse.class);
    }

    public WithdrawResponse retrieveWithdraw(Long withdrawId) {
        String path = "/wallet/v1/withdraws/" + withdrawId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WithdrawResponse.class);
    }

    public WithdrawListResponse searchWithdraws(SearchWithdrawsRequest request) {
        String queryParam = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/wallet/v1/withdraws" + queryParam;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), WithdrawListResponse.class);
    }
}
