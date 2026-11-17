package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.MerchantType;
import io.craftgate.request.ApprovePaymentTransactionsRequest;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.request.DisapprovePaymentTransactionsRequest;
import io.craftgate.request.UpdatePaymentTransactionRequest;
import io.craftgate.response.PaymentTransactionApprovalListResponse;
import io.craftgate.response.PaymentTxPayoutResponse;
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
