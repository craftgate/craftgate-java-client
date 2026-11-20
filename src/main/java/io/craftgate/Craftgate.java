package io.craftgate;

import io.craftgate.adapter.*;
import io.craftgate.request.common.RequestOptions;

import java.net.URI;
import java.net.URISyntaxException;

public class Craftgate {

    private static final String BASE_URL = "https://api.craftgate.io";

    private final PaymentAdapter payment;
    private final InstallmentAdapter installmentAdapter;
    private final OnboardingAdapter onboardingAdapter;
    private final WalletAdapter walletAdapter;
    private final SettlementReportingAdapter settlementReportingAdapter;
    private final SettlementAdapter settlementAdapter;
    private final PaymentReportingAdapter paymentReportingAdapter;
    private final PaymentTokenAdapter paymentTokenAdapter;
    private final FileReportingAdapter fileReportingAdapter;
    private final PayByLinkAdapter payByLinkAdapter;
    private final FraudAdapter fraudAdapter;
    private final HookAdapter hookAdapter;
    private final MasterpassPaymentAdapter masterpassPaymentAdapter;
    private final BankAccountTrackingAdapter bankAccountTrackingAdapter;
    private final MerchantAdapter merchantAdapter;
    private final MerchantApmAdapter merchantApmAdapter;
    private final JuzdanPaymentAdapter juzdanPaymentAdapter;
    private final BkmExpressPaymentAdapter bkmExpressPaymentAdapter;
    private final MealVoucherCardTokenizationAdapter mealVoucherCardTokenizationAdapter;


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
                .baseUrl(requireSecureBaseUrl(baseUrl))
                .language(language)
                .build();

        this.payment = new PaymentAdapter(requestOptions);
        this.installmentAdapter = new InstallmentAdapter(requestOptions);
        this.onboardingAdapter = new OnboardingAdapter(requestOptions);
        this.walletAdapter = new WalletAdapter(requestOptions);
        this.settlementReportingAdapter = new SettlementReportingAdapter(requestOptions);
        this.settlementAdapter = new SettlementAdapter(requestOptions);
        this.paymentReportingAdapter = new PaymentReportingAdapter(requestOptions);
        this.paymentTokenAdapter = new PaymentTokenAdapter(requestOptions);
        this.fileReportingAdapter = new FileReportingAdapter(requestOptions);
        this.payByLinkAdapter = new PayByLinkAdapter(requestOptions);
        this.fraudAdapter = new FraudAdapter(requestOptions);
        this.hookAdapter = new HookAdapter(requestOptions);
        this.masterpassPaymentAdapter = new MasterpassPaymentAdapter(requestOptions);
        this.bankAccountTrackingAdapter = new BankAccountTrackingAdapter(requestOptions);
        this.merchantAdapter = new MerchantAdapter(requestOptions);
        this.merchantApmAdapter = new MerchantApmAdapter(requestOptions);
        this.juzdanPaymentAdapter = new JuzdanPaymentAdapter(requestOptions);
        this.bkmExpressPaymentAdapter = new BkmExpressPaymentAdapter(requestOptions);
        this.mealVoucherCardTokenizationAdapter = new MealVoucherCardTokenizationAdapter(requestOptions);
    }

    /**
     * Credentials and card data must not travel in plain text, so only https base URLs are accepted.
     * Plain http is allowed for loopback hosts to keep local test servers usable.
     */
    private static String requireSecureBaseUrl(String baseUrl) {
        if (baseUrl == null) {
            throw new IllegalArgumentException("baseUrl must not be null");
        }
        URI uri;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("baseUrl is not a valid URL", e);
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (host == null) {
            throw new IllegalArgumentException("baseUrl is not a valid URL");
        }
        if ("https".equalsIgnoreCase(scheme)) {
            return baseUrl;
        }
        if ("http".equalsIgnoreCase(scheme) && isLoopbackHost(host)) {
            return baseUrl;
        }
        throw new IllegalArgumentException("baseUrl must use https");
    }

    private static boolean isLoopbackHost(String host) {
        return "localhost".equalsIgnoreCase(host)
                || "127.0.0.1".equals(host)
                || "[::1]".equals(host);
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

    public PaymentTokenAdapter paymentTokenAdapter() {
        return paymentTokenAdapter;
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

    public HookAdapter hook() {
        return hookAdapter;
    }

    public MasterpassPaymentAdapter masterpass() {
        return masterpassPaymentAdapter;
    }

    public BankAccountTrackingAdapter bankAccountTracking() {
        return bankAccountTrackingAdapter;
    }

    public MerchantAdapter merchant() {
        return merchantAdapter;
    }

    public MerchantApmAdapter merchantApm() {
        return merchantApmAdapter;
    }

    public JuzdanPaymentAdapter juzdan() {
        return juzdanPaymentAdapter;
    }

    public BkmExpressPaymentAdapter bkmExpressPaymentAdapter() {
        return bkmExpressPaymentAdapter;
    }

    public MealVoucherCardTokenizationAdapter mealVoucherCardTokenizationAdapter() {
        return mealVoucherCardTokenizationAdapter;
    }
}
