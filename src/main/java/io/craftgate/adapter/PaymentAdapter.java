package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

import java.util.Map;

public class PaymentAdapter extends BaseAdapter {

    public PaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {
        return createPayment(createPaymentRequest, null);
    }

    public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createPaymentRequest, path, requestContext),
                createPaymentRequest, PaymentResponse.class);
    }

    public PaymentResponse retrievePayment(Long id) {
        String path = "/payment/v1/card-payments/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentResponse.class);
    }

    public InitThreeDSPaymentResponse init3DSPayment(InitThreeDSPaymentRequest initThreeDSPaymentRequest) {
        return init3DSPayment(initThreeDSPaymentRequest, null);
    }

    public InitThreeDSPaymentResponse init3DSPayment(InitThreeDSPaymentRequest initThreeDSPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-payments/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initThreeDSPaymentRequest, path, requestContext),
                initThreeDSPaymentRequest, InitThreeDSPaymentResponse.class);
    }

    public PaymentResponse complete3DSPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest) {
        return complete3DSPayment(completeThreeDSPaymentRequest, null);
    }

    public PaymentResponse complete3DSPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-payments/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeThreeDSPaymentRequest, path, requestContext),
                completeThreeDSPaymentRequest, PaymentResponse.class);
    }

    public PaymentResponse postAuthPayment(long paymentId, PostAuthPaymentRequest postAuthPaymentRequest) {
        return postAuthPayment(paymentId, postAuthPaymentRequest, null);
    }

    public PaymentResponse postAuthPayment(long paymentId, PostAuthPaymentRequest postAuthPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-payments/" + paymentId + "/post-auth";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(postAuthPaymentRequest, path, requestContext),
                postAuthPaymentRequest, PaymentResponse.class);
    }

    public InitCheckoutPaymentResponse initCheckoutPayment(InitCheckoutPaymentRequest initCheckoutPaymentRequest) {
        return initCheckoutPayment(initCheckoutPaymentRequest, null);
    }

    public InitCheckoutPaymentResponse initCheckoutPayment(InitCheckoutPaymentRequest initCheckoutPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/checkout-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initCheckoutPaymentRequest, path, requestContext),
                initCheckoutPaymentRequest, InitCheckoutPaymentResponse.class);
    }

    public InitCheckoutCardVerifyResponse initCheckoutCardVerify(InitCheckoutCardVerifyRequest initCheckoutCardVerifyRequest) {
        return initCheckoutCardVerify(initCheckoutCardVerifyRequest, null);
    }

    public InitCheckoutCardVerifyResponse initCheckoutCardVerify(InitCheckoutCardVerifyRequest initCheckoutCardVerifyRequest, RequestContext requestContext) {
        String path = "/payment/v1/checkout-card-verify/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initCheckoutCardVerifyRequest, path, requestContext),
                initCheckoutCardVerifyRequest, InitCheckoutCardVerifyResponse.class);
    }

    public RetrieveCheckoutCardVerifyResponse retrieveCheckoutCardVerify(String token) {
        String path = "/payment/v1/checkout-card-verify/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), RetrieveCheckoutCardVerifyResponse.class);
    }

    public PaymentResponse retrieveCheckoutPayment(String token) {
        String path = "/payment/v1/checkout-payments/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentResponse.class);
    }

    public void expireCheckoutPayment(String token) {
        expireCheckoutPayment(token, null);
    }

    public void expireCheckoutPayment(String token, RequestContext requestContext) {
        String path = "/payment/v1/checkout-payments/" + token;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext));
    }

    public DepositPaymentResponse createDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest) {
        return createDepositPayment(createDepositPaymentRequest, null);
    }

    public DepositPaymentResponse createDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/deposits";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositPaymentRequest, path, requestContext),
                createDepositPaymentRequest, DepositPaymentResponse.class);
    }

    public InitThreeDSPaymentResponse init3DSDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest) {
        return init3DSDepositPayment(createDepositPaymentRequest, null);
    }

    public InitThreeDSPaymentResponse init3DSDepositPayment(CreateDepositPaymentRequest createDepositPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/deposits/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositPaymentRequest, path, requestContext),
                createDepositPaymentRequest, InitThreeDSPaymentResponse.class);
    }

    public DepositPaymentResponse complete3DSDepositPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest) {
        return complete3DSDepositPayment(completeThreeDSPaymentRequest, null);
    }

    public DepositPaymentResponse complete3DSDepositPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/deposits/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeThreeDSPaymentRequest, path, requestContext),
                completeThreeDSPaymentRequest, DepositPaymentResponse.class);
    }

    public FundTransferDepositPaymentResponse createFundTransferDepositPayment(CreateFundTransferDepositPaymentRequest createFundTransferDepositPaymentRequest) {
        return createFundTransferDepositPayment(createFundTransferDepositPaymentRequest, null);
    }

    public FundTransferDepositPaymentResponse createFundTransferDepositPayment(CreateFundTransferDepositPaymentRequest createFundTransferDepositPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/deposits/fund-transfer";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createFundTransferDepositPaymentRequest, path, requestContext),
                createFundTransferDepositPaymentRequest, FundTransferDepositPaymentResponse.class);
    }

    public ApmDepositPaymentResponse initApmDepositPayment(InitApmDepositPaymentRequest initApmDepositPaymentRequest) {
        return initApmDepositPayment(initApmDepositPaymentRequest, null);
    }

    public ApmDepositPaymentResponse initApmDepositPayment(InitApmDepositPaymentRequest initApmDepositPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/deposits/apm-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initApmDepositPaymentRequest, path, requestContext),
                initApmDepositPaymentRequest, ApmDepositPaymentResponse.class);
    }

    public InitGarantiPayPaymentResponse initGarantiPayPayment(InitGarantiPayPaymentRequest initGarantiPayPaymentRequest) {
        return initGarantiPayPayment(initGarantiPayPaymentRequest, null);
    }

    public InitGarantiPayPaymentResponse initGarantiPayPayment(InitGarantiPayPaymentRequest initGarantiPayPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/garanti-pay-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initGarantiPayPaymentRequest, path, requestContext),
                initGarantiPayPaymentRequest, InitGarantiPayPaymentResponse.class);
    }

    public ApmPaymentInitResponse initApmPayment(InitApmPaymentRequest request) {
        return initApmPayment(request, null);
    }

    public ApmPaymentInitResponse initApmPayment(InitApmPaymentRequest request, RequestContext requestContext) {
        String path = "/payment/v1/apm-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, ApmPaymentInitResponse.class);
    }

    public ApmPaymentCompleteResponse completeApmPayment(CompleteApmPaymentRequest request) {
        return completeApmPayment(request, null);
    }

    public ApmPaymentCompleteResponse completeApmPayment(CompleteApmPaymentRequest request, RequestContext requestContext) {
        String path = "/payment/v1/apm-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, ApmPaymentCompleteResponse.class);
    }

    public PaymentResponse createApmPayment(CreateApmPaymentRequest request) {
        return createApmPayment(request, null);
    }

    public PaymentResponse createApmPayment(CreateApmPaymentRequest request, RequestContext requestContext) {
        String path = "/payment/v1/apm-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, PaymentResponse.class);
    }

    public InitPosApmPaymentResponse initPosApmPayment(InitPosApmPaymentRequest request) {
        return initPosApmPayment(request, null);
    }

    public InitPosApmPaymentResponse initPosApmPayment(InitPosApmPaymentRequest request, RequestContext requestContext) {
        String path = "/payment/v1/pos-apm-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, InitPosApmPaymentResponse.class);
    }

    public PaymentResponse completePosApmPayment(CompletePosApmPaymentRequest request) {
        return completePosApmPayment(request, null);
    }

    public PaymentResponse completePosApmPayment(CompletePosApmPaymentRequest request, RequestContext requestContext) {
        String path = "/payment/v1/pos-apm-payments/complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestContext),
                request, PaymentResponse.class);
    }

    public RetrieveLoyaltiesResponse retrieveLoyalties(RetrieveLoyaltiesRequest retrieveLoyaltiesRequest) {
        return retrieveLoyalties(retrieveLoyaltiesRequest, null);
    }

    public RetrieveLoyaltiesResponse retrieveLoyalties(RetrieveLoyaltiesRequest retrieveLoyaltiesRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-loyalties/retrieve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(retrieveLoyaltiesRequest, path, requestContext),
                retrieveLoyaltiesRequest, RetrieveLoyaltiesResponse.class);
    }

    public PaymentTransactionRefundResponse refundPaymentTransaction(RefundPaymentTransactionRequest refundPaymentTransactionRequest) {
        return refundPaymentTransaction(refundPaymentTransactionRequest, null);
    }

    public PaymentTransactionRefundResponse refundPaymentTransaction(RefundPaymentTransactionRequest refundPaymentTransactionRequest, RequestContext requestContext) {
        String path = "/payment/v1/refund-transactions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentTransactionRequest, path, requestContext),
                refundPaymentTransactionRequest, PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundResponse retrievePaymentTransactionRefund(Long id) {
        String path = "/payment/v1/refund-transactions/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundResponse refundPaymentTransactionMarkAsRefunded(RefundPaymentTransactionMarkAsRefundedRequest refundPaymentTransactionMarkAsRefundedRequest) {
        return refundPaymentTransactionMarkAsRefunded(refundPaymentTransactionMarkAsRefundedRequest, null);
    }

    public PaymentTransactionRefundResponse refundPaymentTransactionMarkAsRefunded(RefundPaymentTransactionMarkAsRefundedRequest refundPaymentTransactionMarkAsRefundedRequest, RequestContext requestContext) {
        String path = "/payment/v1/refund-transactions/mark-as-refunded";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentTransactionMarkAsRefundedRequest, path, requestContext),
                refundPaymentTransactionMarkAsRefundedRequest, PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundListResponse refundPaymentMarkAsRefunded(RefundPaymentRequest refundPaymentRequest) {
        return refundPaymentMarkAsRefunded(refundPaymentRequest, null);
    }

    public PaymentTransactionRefundListResponse refundPaymentMarkAsRefunded(RefundPaymentRequest refundPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/refunds/mark-as-refunded";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentRequest, path, requestContext),
                refundPaymentRequest, PaymentTransactionRefundListResponse.class);
    }

    public PaymentRefundResponse refundPayment(RefundPaymentRequest refundPaymentRequest) {
        return refundPayment(refundPaymentRequest, null);
    }

    public PaymentRefundResponse refundPayment(RefundPaymentRequest refundPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentRequest, path, requestContext),
                refundPaymentRequest, PaymentRefundResponse.class);
    }

    public RefundWaitingPaymentResponse refundWaitingPayment(RefundWaitingPaymentRequest refundWaitingPaymentRequest) {
        return refundWaitingPayment(refundWaitingPaymentRequest, null);
    }

    public RefundWaitingPaymentResponse refundWaitingPayment(RefundWaitingPaymentRequest refundWaitingPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/refunds/refund-waiting-payment";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundWaitingPaymentRequest, path, requestContext),
                refundWaitingPaymentRequest, RefundWaitingPaymentResponse.class);
    }

    public PaymentRefundResponse retrievePaymentRefund(Long id) {
        String path = "/payment/v1/refunds/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), PaymentRefundResponse.class);
    }

    public StoredCardResponse storeCard(StoreCardRequest storeCardRequest) {
        return storeCard(storeCardRequest, null);
    }

    public StoredCardResponse storeCard(StoreCardRequest storeCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/cards";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(storeCardRequest, path, requestContext),
                storeCardRequest, StoredCardResponse.class);
    }

    public StoredCardResponse updateCard(UpdateCardRequest updateCardRequest) {
        return updateCard(updateCardRequest, null);
    }

    public StoredCardResponse updateCard(UpdateCardRequest updateCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/cards/update";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(updateCardRequest, path, requestContext),
                updateCardRequest, StoredCardResponse.class);
    }

    public StoredCardResponse cloneCard(CloneCardRequest cloneCardRequest) {
        return cloneCard(cloneCardRequest, null);
    }

    public StoredCardResponse cloneCard(CloneCardRequest cloneCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/cards/clone";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(cloneCardRequest, path, requestContext),
                cloneCardRequest, StoredCardResponse.class);
    }

    public StoredCardListResponse searchStoredCards(SearchStoredCardsRequest searchStoredCardsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchStoredCardsRequest);
        String path = "/payment/v1/cards" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), StoredCardListResponse.class);
    }

    public void deleteStoredCard(DeleteStoredCardRequest deleteStoredCardRequest) {
        deleteStoredCard(deleteStoredCardRequest, null);
    }

    public void deleteStoredCard(DeleteStoredCardRequest deleteStoredCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/cards/delete";
        HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(deleteStoredCardRequest, path, requestContext),
                deleteStoredCardRequest, Void.class);
    }

    public VerifyCardResponse verifyCard(VerifyCardRequest verifyCardRequest) {
        return verifyCard(verifyCardRequest, null);
    }

    public VerifyCardResponse verifyCard(VerifyCardRequest verifyCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/cards/verify";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(verifyCardRequest, path, requestContext),
                verifyCardRequest, VerifyCardResponse.class);
    }

    public PaymentTransactionApprovalListResponse approvePaymentTransactions(ApprovePaymentTransactionsRequest approvePaymentTransactionsRequest) {
        return approvePaymentTransactions(approvePaymentTransactionsRequest, null);
    }

    public PaymentTransactionApprovalListResponse approvePaymentTransactions(ApprovePaymentTransactionsRequest approvePaymentTransactionsRequest, RequestContext requestContext) {
        String path = "/payment/v1/payment-transactions/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(approvePaymentTransactionsRequest, path, requestContext),
                approvePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionApprovalListResponse disapprovePaymentTransactions(DisapprovePaymentTransactionsRequest disapprovePaymentTransactionsRequest) {
        return disapprovePaymentTransactions(disapprovePaymentTransactionsRequest, null);
    }

    public PaymentTransactionApprovalListResponse disapprovePaymentTransactions(DisapprovePaymentTransactionsRequest disapprovePaymentTransactionsRequest, RequestContext requestContext) {
        String path = "/payment/v1/payment-transactions/disapprove";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(disapprovePaymentTransactionsRequest, path, requestContext),
                disapprovePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionResponse updatePaymentTransaction(UpdatePaymentTransactionRequest updatePaymentTransactionRequest) {
        String path = "/payment/v1/payment-transactions/" + updatePaymentTransactionRequest.getPaymentTransactionId();
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updatePaymentTransactionRequest, path),
                updatePaymentTransactionRequest, PaymentTransactionResponse.class);
    }

    public Object createApplePayMerchantSession(ApplePayMerchantSessionCreateRequest applePayMerchantSessionCreateRequest) {
        return createApplePayMerchantSession(applePayMerchantSessionCreateRequest, null);
    }

    public Object createApplePayMerchantSession(ApplePayMerchantSessionCreateRequest applePayMerchantSessionCreateRequest, RequestContext requestContext) {
        String path = "/payment/v1/apple-pay/merchant-sessions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(applePayMerchantSessionCreateRequest, path, requestContext),
                applePayMerchantSessionCreateRequest, Object.class);
    }

    public BnplPaymentOfferResponse retrieveBnplPaymentOffers(BnplPaymentOfferRequest bnplPaymentOfferRequest) {
        return retrieveBnplPaymentOffers(bnplPaymentOfferRequest, null);
    }

    public BnplPaymentOfferResponse retrieveBnplPaymentOffers(BnplPaymentOfferRequest bnplPaymentOfferRequest, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/offers";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(bnplPaymentOfferRequest, path, requestContext),
                bnplPaymentOfferRequest, BnplPaymentOfferResponse.class);
    }

    public InitBnplPaymentResponse initBnplPayment(InitBnplPaymentRequest initBnplPaymentRequest) {
        return initBnplPayment(initBnplPaymentRequest, null);
    }

    public InitBnplPaymentResponse initBnplPayment(InitBnplPaymentRequest initBnplPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initBnplPaymentRequest, path, requestContext),
                initBnplPaymentRequest, InitBnplPaymentResponse.class);
    }

    public PaymentResponse approveBnplPayment(Long paymentId) {
        return approveBnplPayment(paymentId, null);
    }

    public PaymentResponse approveBnplPayment(Long paymentId, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/" + paymentId + "/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext), PaymentResponse.class);
    }

    public BnplPaymentVerifyResponse verifyBnplPayment(Long paymentId) {
        return verifyBnplPayment(paymentId, null);
    }

    public BnplPaymentVerifyResponse verifyBnplPayment(Long paymentId, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/" + paymentId + "/verify";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext), BnplPaymentVerifyResponse.class);
    }

    public BnplLimitInquiryResponse bnplLimitInquiryInit(BnplLimitInquiryRequest bnplLimitInquiryRequest) {
        return bnplLimitInquiryInit(bnplLimitInquiryRequest, null);
    }

    public BnplLimitInquiryResponse bnplLimitInquiryInit(BnplLimitInquiryRequest bnplLimitInquiryRequest, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/limit-inquiry/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(bnplLimitInquiryRequest, path, requestContext), BnplLimitInquiryResponse.class);
    }

    public BnplLimitInquiryResponse bnplLimitInquiry(BnplLimitInquiryRequest bnplLimitInquiryRequest) {
        return bnplLimitInquiry(bnplLimitInquiryRequest, null);
    }

    public BnplLimitInquiryResponse bnplLimitInquiry(BnplLimitInquiryRequest bnplLimitInquiryRequest, RequestContext requestContext) {
        String path = "/payment/v1/bnpl-payments/limit-inquiry";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(bnplLimitInquiryRequest, path, requestContext), BnplLimitInquiryResponse.class);
    }

    public InstantTransferBanksResponse retrieveActiveBanks() {
        String path = "/payment/v1/instant-transfer-banks";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path),
                InstantTransferBanksResponse.class);
    }

    public InitMultiPaymentResponse initMultiPayment(InitMultiPaymentRequest initMultiPaymentRequest) {
        return initMultiPayment(initMultiPaymentRequest, null);
    }

    public InitMultiPaymentResponse initMultiPayment(InitMultiPaymentRequest initMultiPaymentRequest, RequestContext requestContext) {
        String path = "/payment/v1/multi-payments/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initMultiPaymentRequest, path, requestContext),
                initMultiPaymentRequest, InitMultiPaymentResponse.class);
    }

    public MultiPaymentResponse retrieveMultiPayment(String token) {
        String path = "/payment/v1/multi-payments/" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), MultiPaymentResponse.class);
    }

    public StoredCardListResponse retrieveProviderCards(RetrieveProviderCardRequest retrieveProviderCardRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(retrieveProviderCardRequest);
        String path = "/payment/v1/cards/provider-card-mappings" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), StoredCardListResponse.class);
    }

    public CreateDepositToCardPaymentResponse depositToCard(CreateDepositToCardRequest createDepositToCardRequest) {
        return depositToCard(createDepositToCardRequest, null);
    }

    public CreateDepositToCardPaymentResponse depositToCard(CreateDepositToCardRequest createDepositToCardRequest, RequestContext requestContext) {
        String path = "/payment/v1/card-payments/deposit-to-card";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createDepositToCardRequest, path, requestContext),
                createDepositToCardRequest, CreateDepositToCardPaymentResponse.class);
    }

    public boolean is3DSecureCallbackVerified(String threeDSecureCallbackKey, Map<String, String> params) {
        String hash = params.get("hash");
        String hashString = threeDSecureCallbackKey +
                "###" +
                params.getOrDefault("status", "") +
                "###" +
                params.getOrDefault("completeStatus", "") +
                "###" +
                params.getOrDefault("paymentId", "") +
                "###" +
                params.getOrDefault("conversationData", "") +
                "###" +
                params.getOrDefault("conversationId", "") +
                "###" +
                params.getOrDefault("callbackStatus", "");

        String hashedParams = HashGenerator.generateHash(hashString);
        return hash.equals(hashedParams);
    }
}
