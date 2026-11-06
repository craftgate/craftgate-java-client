package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.AccountOwner;
import io.craftgate.model.Currency;
import io.craftgate.model.MerchantType;
import io.craftgate.model.PayoutAccountType;
import io.craftgate.request.ApprovePaymentTransactionsRequest;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.CreatePayoutAccountRequest;
import io.craftgate.request.DeletePayoutAccountRequest;
import io.craftgate.request.DisapprovePaymentTransactionsRequest;
import io.craftgate.request.SearchPayoutAccountRequest;
import io.craftgate.request.UpdatePaymentTransactionRequest;
import io.craftgate.request.UpdatePayoutAccountRequest;
import io.craftgate.response.PaymentTransactionApprovalListResponse;
import io.craftgate.response.PaymentTxPayoutResponse;
import io.craftgate.response.PayoutAccountListResponse;
import io.craftgate.response.PayoutAccountResponse;
import io.craftgate.response.SettlementResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettlementSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_instant_wallet_settlement() {
        CreateInstantWalletSettlementRequest request = CreateInstantWalletSettlementRequest.builder()
                .build();

        SettlementResponse response = craftgate.settlement().createInstantWalletSettlement(request);
        assertNotNull(response.getSettlementResultStatus());
    }

    @Test
    void create_merchant_payout_account() {
        CreatePayoutAccountRequest request = CreatePayoutAccountRequest.builder()
                .accountOwner(AccountOwner.MERCHANT)
                .currency(Currency.USD)
                .type(PayoutAccountType.WISE)
                .externalAccountId("wiseRecipientId")
                .build();

        PayoutAccountResponse response = craftgate.settlement().createPayoutAccount(request);
        assertNotNull(response.getId());
    }

    @Test
    void create_sub_merchant_payout_account() {
        CreatePayoutAccountRequest request = CreatePayoutAccountRequest.builder()
                .accountOwner(AccountOwner.SUB_MERCHANT_MEMBER)
                .subMerchantMemberId(1L)
                .currency(Currency.USD)
                .type(PayoutAccountType.WISE)
                .externalAccountId("wiseRecipientId")
                .build();

        PayoutAccountResponse response = craftgate.settlement().createPayoutAccount(request);
        assertNotNull(response.getId());
    }

    @Test
    void update_payout_account() {
        UpdatePayoutAccountRequest request = UpdatePayoutAccountRequest.builder()
                .type(PayoutAccountType.WISE)
                .externalAccountId("wiseRecipientId2")
                .build();

        craftgate.settlement().updatePayoutAccount(11L, request);
    }

    @Test
    void search_payout_account() {
        SearchPayoutAccountRequest request = SearchPayoutAccountRequest.builder()
                .accountOwner(AccountOwner.MERCHANT)
                .currency(Currency.USD)
                .page(0)
                .size(10)
                .build();

        PayoutAccountListResponse response = craftgate.settlement().searchPayoutAccount(request);
        assertNotNull(response.getItems());
    }

    @Test
    void delete_payout_account() {
        craftgate.settlement().deletePayoutAccount(DeletePayoutAccountRequest.builder()
                .id(10L)
                .build());
    }

    @Test
    void approve_payment_transactions() {
        ApprovePaymentTransactionsRequest request = ApprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = craftgate.settlement().approvePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void disapprove_payment_transactions() {
        DisapprovePaymentTransactionsRequest request = DisapprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = craftgate.settlement().disapprovePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void update_payment_transaction() {
        UpdatePaymentTransactionRequest request = UpdatePaymentTransactionRequest.builder()
                .paymentTransactionId(10L)
                .subMerchantMemberId(1L)
                .subMerchantMemberPrice(BigDecimal.TEN)
                .build();

        PaymentTxPayoutResponse response = craftgate.settlement().updatePaymentTransaction(request);
        assertEquals(request.getPaymentTransactionId(), response.getPaymentTransactionId());
        assertTrue(response.getPayoutItems().stream()
                .anyMatch(item -> item.getMerchantType() == MerchantType.SUB_MERCHANT_MEMBER && request.getSubMerchantMemberId().equals(item.getMerchantId())));
    }
}
