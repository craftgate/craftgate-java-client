package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.ApprovePaymentTransactionsRequest;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.DisapprovePaymentTransactionsRequest;
import io.craftgate.request.UpdatePaymentTransactionRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.PaymentTransactionApprovalListResponse;
import io.craftgate.response.PaymentTxPayoutResponse;
import io.craftgate.response.SettlementResponse;

public class SettlementAdapter extends BaseAdapter {

    public SettlementAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public SettlementResponse createInstantWalletSettlement(CreateInstantWalletSettlementRequest request) {
        String path = "/settlement/v1/instant-wallet-settlements";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions), request, SettlementResponse.class);
    }

    public PaymentTransactionApprovalListResponse approvePaymentTransactions(ApprovePaymentTransactionsRequest approvePaymentTransactionsRequest) {
        String path = "/settlement/v1/payment-transactions/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(approvePaymentTransactionsRequest, path, requestOptions),
                approvePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionApprovalListResponse disapprovePaymentTransactions(DisapprovePaymentTransactionsRequest disapprovePaymentTransactionsRequest) {
        String path = "/settlement/v1/payment-transactions/disapprove";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(disapprovePaymentTransactionsRequest, path, requestOptions),
                disapprovePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTxPayoutResponse updatePaymentTransaction(UpdatePaymentTransactionRequest updatePaymentTransactionRequest) {
        String path = "/settlement/v1/payment-transactions/" + updatePaymentTransactionRequest.getPaymentTransactionId();
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updatePaymentTransactionRequest, path, requestOptions),
                updatePaymentTransactionRequest, PaymentTxPayoutResponse.class);
    }
}
