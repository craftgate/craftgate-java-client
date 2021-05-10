package io.craftgate;

import io.craftgate.adapter.*;
import io.craftgate.request.common.RequestOptions;

public class Craftgate {

    private static final String BASE_URL = "https://api.craftgate.io";

    private final PaymentAdapter payment;
    private final InstallmentAdapter installmentAdapter;
    private final OnboardingAdapter onboardingAdapter;
    private final WalletAdapter walletAdapter;
    private final SettlementReportingAdapter settlementReportingAdapter;
    private final SettlementAdapter settlementAdapter;
    private final PaymentReportingAdapter paymentReportingAdapter;

    public Craftgate(String apiKey, String secretKey) {
        this(apiKey, secretKey, BASE_URL);
    }

    public Craftgate(String apiKey, String secretKey, String baseUrl) {
        RequestOptions requestOptions = RequestOptions.builder()
                .apiKey(apiKey)
                .secretKey(secretKey)
                .baseUrl(baseUrl)
                .build();

        this.payment = new PaymentAdapter(requestOptions);
        this.installmentAdapter = new InstallmentAdapter(requestOptions);
        this.onboardingAdapter = new OnboardingAdapter(requestOptions);
        this.walletAdapter = new WalletAdapter(requestOptions);
        this.settlementReportingAdapter = new SettlementReportingAdapter(requestOptions);
        this.settlementAdapter = new SettlementAdapter(requestOptions);
        this.paymentReportingAdapter = new PaymentReportingAdapter(requestOptions);
    }

    public PaymentAdapter payment() {
        return payment;
    }

    public InstallmentAdapter installment() {
        return installmentAdapter;
    }

    public OnboardingAdapter onboarding() {
        return onboardingAdapter;
    }

    public WalletAdapter wallet() {
        return walletAdapter;
    }

    public PaymentReportingAdapter paymentReporting() {
        return paymentReportingAdapter;
    }

    public SettlementReportingAdapter settlementReporting() {
        return settlementReportingAdapter;
    }

    public SettlementAdapter settlement() {
        return settlementAdapter;
    }
}
