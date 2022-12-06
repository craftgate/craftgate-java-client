package io.craftgate;

import io.craftgate.adapter.*;
import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.RequestOptions;

import java.util.Map;

public class Craftgate {

    private static final String BASE_URL = "https://api.craftgate.io";

    private final PaymentAdapter payment;
    private final InstallmentAdapter installmentAdapter;
    private final OnboardingAdapter onboardingAdapter;
    private final WalletAdapter walletAdapter;
    private final SettlementReportingAdapter settlementReportingAdapter;
    private final SettlementAdapter settlementAdapter;
    private final PaymentReportingAdapter paymentReportingAdapter;
    private final FileReportingAdapter fileReportingAdapter;
    private final PayByLinkAdapter payByLinkAdapter;
    private final FraudAdapter fraudAdapter;

    public Craftgate(String apiKey, String secretKey) {
        this(apiKey, secretKey, BASE_URL, null);
    }

    public Craftgate(String apiKey, String secretKey, String baseUrl) {
        this(apiKey, secretKey, baseUrl, null);
    }

    public Craftgate(String apiKey, String secretKey, String baseUrl, String language) {
        RequestOptions requestOptions = RequestOptions.builder()
                .apiKey(apiKey)
                .secretKey(secretKey)
                .baseUrl(baseUrl)
                .language(language)
                .build();

        this.payment = new PaymentAdapter(requestOptions);
        this.installmentAdapter = new InstallmentAdapter(requestOptions);
        this.onboardingAdapter = new OnboardingAdapter(requestOptions);
        this.walletAdapter = new WalletAdapter(requestOptions);
        this.settlementReportingAdapter = new SettlementReportingAdapter(requestOptions);
        this.settlementAdapter = new SettlementAdapter(requestOptions);
        this.paymentReportingAdapter = new PaymentReportingAdapter(requestOptions);
        this.fileReportingAdapter = new FileReportingAdapter(requestOptions);
        this.payByLinkAdapter = new PayByLinkAdapter(requestOptions);
        this.fraudAdapter = new FraudAdapter(requestOptions);
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

    public FileReportingAdapter fileReporting() {
        return fileReportingAdapter;
    }

    public SettlementReportingAdapter settlementReporting() {
        return settlementReportingAdapter;
    }

    public SettlementAdapter settlement() {
        return settlementAdapter;
    }

    public PayByLinkAdapter payByLink() {
        return payByLinkAdapter;
    }

    public FraudAdapter fraud() {
        return fraudAdapter;
    }

    public boolean is3DSecureCallbackVerified(String threeDSecureCallbackKey, Map<String, String> params) {
        String hash = params.get("hash");
        String hashString = new StringBuilder(threeDSecureCallbackKey)
                .append("###")
                .append(params.getOrDefault("status", ""))
                .append("###")
                .append(params.getOrDefault("completeStatus", ""))
                .append("###")
                .append(params.getOrDefault("paymentId", ""))
                .append("###")
                .append(params.getOrDefault("conversationData", ""))
                .append("###")
                .append(params.getOrDefault("conversationId", ""))
                .append("###")
                .append(params.getOrDefault("callbackStatus", ""))
                .toString();

        String hashedParams = HashGenerator.generateHash(hashString);
        return hash.equals(hashedParams);
    }
}
