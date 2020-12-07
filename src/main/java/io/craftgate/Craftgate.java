package io.craftgate;

import io.craftgate.adapter.InstallmentAdapter;
import io.craftgate.adapter.OnboardingAdapter;
import io.craftgate.adapter.PaymentAdapter;
import io.craftgate.request.common.RequestOptions;

public class Craftgate {

    private static final String BASE_URL = "https://api.craftgate.io";

    private final PaymentAdapter payment;
    private final InstallmentAdapter installmentAdapter;
    private final OnboardingAdapter onboardingAdapter;

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

}
