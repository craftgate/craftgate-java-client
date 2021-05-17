package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.*;
import io.craftgate.request.*;
import io.craftgate.response.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WalletSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieveMemberWallet() {
        Long memberId = 1L;

        WalletResponse response = craftgate.wallet().retrieveMemberWallet(memberId);

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedDate());
        assertNotNull(response.getAmount());
        assertNotNull(response.getWithdrawalAmount());
        assertEquals(memberId, response.getMemberId());
        assertEquals(Currency.TRY, response.getCurrency());
    }

    @Test
    void search_wallet_transactions() {
        Long walletId = 1L;

        SearchWalletTransactionsRequest request = SearchWalletTransactionsRequest.builder()
                .build();

        WalletTransactionListResponse response = craftgate.wallet().searchWalletTransactions(walletId, request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void remittance_send() {
        long memberId = 1L;
        BigDecimal price = BigDecimal.valueOf(50);

        CreateRemittanceRequest request = CreateRemittanceRequest.builder()
                .memberId(memberId)
                .price(price)
                .description("Loyalty send to memberId" + memberId)
                .remittanceReasonType(RemittanceReasonType.REDEEM_ONLY_LOYALTY)
                .build();

        RemittanceResponse response = craftgate.wallet().sendRemittance(request);
        assertNotNull(response);
        assertEquals(request.getMemberId(), response.getMemberId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getDescription(), response.getDescription());
        assertEquals(RemittanceType.SEND, response.getRemittanceType());
        assertEquals(RemittanceReasonType.REDEEM_ONLY_LOYALTY, response.getRemittanceReasonType());
    }

    @Test
    void remittance_receive() {
        long memberId = 1L;
        BigDecimal price = BigDecimal.valueOf(50);

        CreateRemittanceRequest request = CreateRemittanceRequest.builder()
                .memberId(memberId)
                .price(price)
                .description("Loyalty received from memberId" + memberId)
                .remittanceReasonType(RemittanceReasonType.REDEEM_ONLY_LOYALTY)
                .build();

        RemittanceResponse response = craftgate.wallet().receiveRemittance(request);
        assertNotNull(response);
        assertEquals(request.getMemberId(), response.getMemberId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getDescription(), response.getDescription());
        assertEquals(RemittanceType.RECEIVE, response.getRemittanceType());
        assertEquals(RemittanceReasonType.REDEEM_ONLY_LOYALTY, response.getRemittanceReasonType());
    }

    @Test
    void retrieve_merchant_member_wallet() {
        WalletResponse response = craftgate.wallet().retrieveMerchantMemberWallet();

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedDate());
        assertNotNull(response.getMemberId());
        assertNotNull(response.getAmount());
        assertEquals(Currency.TRY, response.getCurrency());
    }

    @Test
    void reset_merchant_member_wallet_balance() {
        ResetMerchantMemberWalletBalanceRequest request = ResetMerchantMemberWalletBalanceRequest.builder()
                .walletAmount(BigDecimal.valueOf(-100))
                .build();

        WalletResponse response = craftgate.wallet().resetMerchantMemberWalletBalance(request);

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedDate());
        assertNotNull(response.getMemberId());
        assertEquals(BigDecimal.ZERO, response.getAmount());
        assertEquals(Currency.TRY, response.getCurrency());
    }

    @Test
    void retrieve_refundable_amount_of_wallet_transaction() {
        long walletTransactionId = 1;

        WalletTransactionRefundableAmountResponse response = craftgate.wallet().retrieveRefundableAmountOfWalletTransaction(walletTransactionId);

        assertTrue(response.getRefundableAmount().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void refund_wallet_transaction_to_card() {
        long walletTransactionId = 1;

        RefundWalletTransactionToCardRequest request = RefundWalletTransactionToCardRequest.builder()
                .refundPrice(BigDecimal.TEN)
                .build();

        RefundWalletTransactionToCardResponse response = craftgate.wallet().refundWalletTransactionToCard(walletTransactionId, request);

        assertNotNull(response.getId());
        assertNull(response.getPaymentError());
        assertEquals(RefundStatus.SUCCESS, response.getRefundStatus());
        assertEquals(WalletTransactionRefundCardTransactionType.PAYMENT, response.getTransactionType());
        assertEquals(walletTransactionId, response.getWalletTransactionId());
        assertEquals(request.getRefundPrice(), response.getRefundPrice());
    }

    @Test
    void retrieve_wallet_transactions_to_card() {
        long walletTransactionId = 1;

        RefundWalletTransactionToCardListResponse response = craftgate.wallet().retrieveRefundWalletTransactionsToCard(walletTransactionId);

        assertNotNull(response.getItems());
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void create_withdraw() {
        CreateWithdrawRequest request = CreateWithdrawRequest.builder()
                .memberId(1L)
                .price(BigDecimal.valueOf(100))
                .description("Hakediş Çekme Talebi")
                .currency(Currency.TRY)
                .build();

        WithdrawResponse response = craftgate.wallet().createWithdraw(request);

        assertNotNull(response.getId());
        assertNull(response.getPayoutId());
        assertNotNull(response.getCreatedDate());
        assertEquals(Status.ACTIVE, response.getStatus());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getDescription(), response.getDescription());
        assertEquals(TransactionPayoutStatus.WAITING_FOR_PAYOUT, response.getPayoutStatus());
        assertEquals(request.getMemberId(), response.getMemberId());
    }

    @Test
    void cancel_withdraw() {
        Long withdrawId = 1L;

        WithdrawResponse response = craftgate.wallet().cancelWithdraw(withdrawId);

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedDate());
        assertEquals(Status.ACTIVE, response.getStatus());
        assertEquals(TransactionPayoutStatus.CANCELLED, response.getPayoutStatus());
    }

    @Test
    void retrieve_withdraw() {
        long withdrawId = 1L;

        WithdrawResponse response = craftgate.wallet().retrieveWithdraw(withdrawId);

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedDate());
        assertEquals(Status.ACTIVE, response.getStatus());
        assertEquals(Currency.TRY, response.getCurrency());
        assertEquals(TransactionPayoutStatus.WAITING_FOR_PAYOUT, response.getPayoutStatus());
    }

    @Test
    void search_withdraws() {
        SearchWithdrawsRequest request = SearchWithdrawsRequest.builder()
                .payoutStatus(TransactionPayoutStatus.WAITING_FOR_PAYOUT)
                .minWithdrawPrice(BigDecimal.valueOf(5))
                .maxWithdrawPrice(BigDecimal.valueOf(1000))
                .build();

        WithdrawListResponse response = craftgate.wallet().searchWithdraws(request);

        assertNotNull(response.getPage());
        assertNotNull(response.getSize());
        assertNotNull(response.getTotalSize());
        assertTrue(response.getItems().size() > 0);
    }
}
