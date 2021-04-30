package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentStatus;
import io.craftgate.model.PaymentType;
import io.craftgate.model.RefundStatus;
import io.craftgate.request.SearchPaymentsRequest;
import io.craftgate.request.SearchRefundTransactionsRequest;
import io.craftgate.request.SearchRefundsRequest;
import io.craftgate.response.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentReportingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_payments() {
        SearchPaymentsRequest searchPaymentsRequest = SearchPaymentsRequest.builder()
                .page(0)
                .size(10)
                .paymentId(100L)
                .paymentTransactionId(1000L)
                .buyerMemberId(1L)
                .conversationId("conversationId")
                .externalId("externalId")
                .merchantPosId(1L)
                .orderId("orderId")
                .paymentType(PaymentType.CARD_PAYMENT)
                .paymentStatus(PaymentStatus.SUCCESS)
                .binNumber("123456")
                .lastFourDigits("1234")
                .currency(Currency.TRY)
                .minPaidPrice(BigDecimal.ZERO)
                .maxPaidPrice(BigDecimal.valueOf(100))
                .installment(1)
                .isThreeDS(false)
                .minCreatedDate(LocalDateTime.MIN)
                .maxCreatedDate(LocalDateTime.now())
                .build();

        PaymentReportingListResponse response = craftgate.paymentReporting().searchPayments(searchPaymentsRequest);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment() {
        long paymentId = 1L;

        PaymentReportingResponse response = craftgate.paymentReporting().retrievePayment(paymentId);

        assertEquals(paymentId, response.getId());
        assertNotNull(response.getPrice());
        assertNotNull(response.getPaidPrice());
        assertNotNull(response.getPaymentType());
        assertNotNull(response.getPaymentStatus());
        assertNotNull(response.getRefundablePrice());
    }

    @Test
    void retrieve_payment_transactions() {
        long paymentId = 1L;

        PaymentTransactionListResponse response = craftgate.paymentReporting().retrievePaymentTransactions(paymentId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment_refunds() {
        long paymentId = 1L;

        PaymentRefundReportingListResponse response = craftgate.paymentReporting().retrievePaymentRefunds(paymentId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment_transaction_refunds() {
        long paymentId = 1L;
        long paymentTransactionId = 100L;

        PaymentTransactionRefundReportingListResponse response = craftgate.paymentReporting().retrievePaymentTransactionRefunds(paymentId, paymentTransactionId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_payment_refunds() {
        SearchRefundsRequest searchRefundsRequest = SearchRefundsRequest.builder()
                .page(0)
                .size(10)
                .id(1L)
                .paymentId(100L)
                .buyerMemberId(1L)
                .conversationId("conversationId")
                .merchantPosId(1L)
                .refundStatus(RefundStatus.SUCCESS)
                .currency(Currency.TRY)
                .minRefundPrice(BigDecimal.ZERO)
                .maxRefundPrice(BigDecimal.valueOf(100))
                .minCreatedDate(LocalDateTime.MIN)
                .maxCreatedDate(LocalDateTime.now())
                .build();

        PaymentRefundSearchListResponse response = craftgate.paymentReporting().searchPaymentRefunds(searchRefundsRequest);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_payment_transaction_refunds() {
        SearchRefundTransactionsRequest searchPaymentTransactionRefundsRequest = SearchRefundTransactionsRequest.builder()
                .page(0)
                .size(10)
                .id(1L)
                .paymentId(100L)
                .paymentTransactionId(1000L)
                .buyerMemberId(1L)
                .conversationId("conversationId")
                .merchantPosId(1L)
                .refundStatus(RefundStatus.SUCCESS)
                .currency(Currency.TRY)
                .minRefundPrice(BigDecimal.ZERO)
                .maxRefundPrice(BigDecimal.valueOf(100))
                .isAfterSettlement(false)
                .minCreatedDate(LocalDateTime.MIN)
                .maxCreatedDate(LocalDateTime.now())
                .build();

        PaymentTransactionRefundSearchListResponse response = craftgate.paymentReporting().searchPaymentTransactionRefunds(searchPaymentTransactionRefundsRequest);
        assertTrue(response.getItems().size() > 0);
    }
}
