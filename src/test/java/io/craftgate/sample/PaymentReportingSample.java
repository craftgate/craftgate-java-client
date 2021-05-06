package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentStatus;
import io.craftgate.model.PaymentType;
import io.craftgate.model.RefundStatus;
import io.craftgate.request.SearchPaymentRefundsRequest;
import io.craftgate.request.SearchPaymentTransactionRefundsRequest;
import io.craftgate.request.SearchPaymentsRequest;
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
                .orderId("orderId")
                .paymentType(PaymentType.CARD_PAYMENT)
                .paymentStatus(PaymentStatus.SUCCESS)
                .binNumber("123456")
                .lastFourDigits("1234")
                .currency(Currency.TRY)
                .minPaidPrice(BigDecimal.ONE)
                .maxPaidPrice(BigDecimal.valueOf(100))
                .installment(1)
                .isThreeDS(false)
                .minCreatedDate(LocalDateTime.now().minusDays(30L))
                .maxCreatedDate(LocalDateTime.now())
                .build();

        ReportingPaymentListResponse response = craftgate.paymentReporting().searchPayments(searchPaymentsRequest);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment() {
        long paymentId = 1L;

        ReportingPaymentResponse response = craftgate.paymentReporting().retrievePayment(paymentId);

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

        ReportingPaymentTransactionListResponse response = craftgate.paymentReporting().retrievePaymentTransactions(paymentId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment_refunds() {
        long paymentId = 1L;

        ReportingPaymentRefundListResponse response = craftgate.paymentReporting().retrievePaymentRefunds(paymentId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payment_transaction_refunds() {
        long paymentId = 1L;
        long paymentTransactionId = 100L;

        ReportingPaymentTransactionRefundListResponse response = craftgate.paymentReporting().retrievePaymentTransactionRefunds(paymentId, paymentTransactionId);

        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_payment_refunds() {
        SearchPaymentRefundsRequest searchPaymentRefundsRequest = SearchPaymentRefundsRequest.builder()
                .page(0)
                .size(10)
                .id(1L)
                .paymentId(100L)
                .buyerMemberId(1L)
                .conversationId("conversationId")
                .refundStatus(RefundStatus.SUCCESS)
                .currency(Currency.TRY)
                .minRefundPrice(BigDecimal.ONE)
                .maxRefundPrice(BigDecimal.valueOf(100))
                .minCreatedDate(LocalDateTime.now().minusDays(30))
                .maxCreatedDate(LocalDateTime.now())
                .build();

        ReportingSearchPaymentRefundListResponse response = craftgate.paymentReporting().searchPaymentRefunds(searchPaymentRefundsRequest);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_payment_transaction_refunds() {
        SearchPaymentTransactionRefundsRequest searchPaymentTransactionRefundsRequest = SearchPaymentTransactionRefundsRequest.builder()
                .page(0)
                .size(10)
                .id(1L)
                .paymentId(100L)
                .paymentTransactionId(1000L)
                .buyerMemberId(1L)
                .conversationId("conversationId")
                .refundStatus(RefundStatus.SUCCESS)
                .currency(Currency.TRY)
                .minRefundPrice(BigDecimal.ONE)
                .maxRefundPrice(BigDecimal.valueOf(100))
                .isAfterSettlement(false)
                .minCreatedDate(LocalDateTime.now().minusDays(30))
                .maxCreatedDate(LocalDateTime.now())
                .build();

        ReportingSearchPaymentTransactionRefundListResponse response = craftgate.paymentReporting().searchPaymentTransactionRefunds(searchPaymentTransactionRefundsRequest);
        assertTrue(response.getItems().size() > 0);
    }
}
