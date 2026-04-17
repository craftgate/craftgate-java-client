package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

public class WalletAdapter extends BaseAdapter {

    public WalletAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public WalletResponse createWallet(Long memberId, CreateWalletRequest request) {
        return createWallet(memberId, request, null);
    }

    public WalletResponse createWallet(Long memberId, CreateWalletRequest request, RequestContext requestContext) {
        String path = "/wallet/v1/members/" + memberId + "/wallets";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, WalletResponse.class);
    }

    public WalletResponse retrieveMemberWallet(Long memberId) {
        String path = "/wallet/v1/members/" + memberId + "/wallet";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WalletResponse.class);
    }

    public WalletTransactionListResponse searchWalletTransactions(Long walletId, SearchWalletTransactionsRequest searchWalletTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchWalletTransactionsRequest);
        String path = "/wallet/v1/wallets/" + walletId + "/wallet-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WalletTransactionListResponse.class);
    }

    public WalletResponse updateWallet(Long memberId, Long walletId, UpdateWalletRequest request) {
        String path = "/wallet/v1/members/" + memberId + "/wallets/" + walletId;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(request, path), request, WalletResponse.class);
    }

    public RemittanceResponse sendRemittance(CreateRemittanceRequest createRemittanceRequest) {
        return sendRemittance(createRemittanceRequest, null);
    }

    public RemittanceResponse sendRemittance(CreateRemittanceRequest createRemittanceRequest, RequestContext requestContext) {
        String path = "/wallet/v1/remittances/send";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createRemittanceRequest, path, requestContext),
                createRemittanceRequest, RemittanceResponse.class);
    }

    public RemittanceResponse receiveRemittance(CreateRemittanceRequest createRemittanceRequest) {
        return receiveRemittance(createRemittanceRequest, null);
    }

    public RemittanceResponse receiveRemittance(CreateRemittanceRequest createRemittanceRequest, RequestContext requestContext) {
        String path = "/wallet/v1/remittances/receive";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createRemittanceRequest, path, requestContext),
                createRemittanceRequest, RemittanceResponse.class);
    }

    public RemittanceResponse retrieveRemittance(Long id) {
        String path = "/wallet/v1/remittances/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), RemittanceResponse.class);
    }

    public WalletResponse retrieveMerchantMemberWallet() {
        String path = "/wallet/v1/merchants/me/wallet";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WalletResponse.class);
    }

    public WalletResponse resetMerchantMemberWalletBalance(ResetMerchantMemberWalletBalanceRequest request) {
        return resetMerchantMemberWalletBalance(request, null);
    }

    public WalletResponse resetMerchantMemberWalletBalance(ResetMerchantMemberWalletBalanceRequest request, RequestContext requestContext) {
        String path = "/wallet/v1/merchants/me/wallet/reset-balance";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, WalletResponse.class);
    }

    public WalletTransactionRefundableAmountResponse retrieveRefundableAmountOfWalletTransaction(Long walletTransactionId) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refundable-amount";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WalletTransactionRefundableAmountResponse.class);
    }

    public RefundWalletTransactionResponse refundWalletTransaction(Long walletTransactionId, RefundWalletTransactionToCardRequest request) {
        return refundWalletTransaction(walletTransactionId, request, null);
    }

    public RefundWalletTransactionResponse refundWalletTransaction(Long walletTransactionId, RefundWalletTransactionToCardRequest request, RequestContext requestContext) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, RefundWalletTransactionResponse.class);
    }

    public RefundWalletTransactionListResponse retrieveRefundWalletTransactions(Long walletTransactionId) {
        String path = "/payment/v1/wallet-transactions/" + walletTransactionId + "/refunds";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), RefundWalletTransactionListResponse.class);
    }

    public WithdrawResponse createWithdraw(CreateWithdrawRequest request) {
        return createWithdraw(request, null);
    }

    public WithdrawResponse createWithdraw(CreateWithdrawRequest request, RequestContext requestContext) {
        String path = "/wallet/v1/withdraws";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext), request, WithdrawResponse.class);
    }

    public WithdrawResponse cancelWithdraw(Long withdrawId) {
        return cancelWithdraw(withdrawId, null);
    }

    public WithdrawResponse cancelWithdraw(Long withdrawId, RequestContext requestContext) {
        String path = "/wallet/v1/withdraws/" + withdrawId + "/cancel";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext), WithdrawResponse.class);
    }

    public WithdrawResponse retrieveWithdraw(Long withdrawId) {
        String path = "/wallet/v1/withdraws/" + withdrawId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WithdrawResponse.class);
    }

    public WithdrawListResponse searchWithdraws(SearchWithdrawsRequest request) {
        String queryParam = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/wallet/v1/withdraws" + queryParam;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), WithdrawListResponse.class);
    }
}
