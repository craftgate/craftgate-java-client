package io.craftgate.adapter;

import com.google.gson.Gson;
import io.craftgate.model.FraudCheckStatus;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.request.DeleteProductRequest;
import io.craftgate.request.SearchProductsRequest;
import io.craftgate.request.UpdateFraudCheckStatusRequest;
import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.HeaderOptions;
import io.craftgate.request.common.Jsons;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseRequestFoundationTest {

    private static final String IDEMPOTENCY_KEY_HEADER_NAME = "x-idempotency-key";
    private static final String RANDOM_HEADER_NAME = "x-rnd-key";
    private static final String SIGNATURE_HEADER_NAME = "x-signature";

    private final RequestOptions requestOptions = RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build();

    private final PaymentTokenAdapter bodyAdapter = new PaymentTokenAdapter(requestOptions);
    private final PayByLinkAdapter wrapperAdapter = new PayByLinkAdapter(requestOptions);

    private static HeaderOptions idempotencyKey(String key) {
        return HeaderOptions.builder()
                .idempotencyKey(key)
                .build();
    }

    @Test
    void superbuilder_includes_inherited_header_options() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .issuer("issuer")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        assertEquals("idempotency-key-1", request.getHeaderOptions().getIdempotencyKey());
        assertEquals("card-value", request.getValue());
    }

    @Test
    void header_options_default_to_null_when_not_set() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder().value("card-value").build();

        assertNull(request.getHeaderOptions());
    }

    @Test
    void header_options_are_excluded_from_serialized_body_and_signature() {
        Gson gson = Jsons.getGson();
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        String json = gson.toJson(request);

        assertTrue(json.contains("card-value"));
        assertFalse(json.contains("headerOptions"));
        assertFalse(json.contains("idempotencyKey"));
        assertFalse(json.contains("idempotency-key-1"));
    }

    @Test
    void serialized_body_is_identical_with_and_without_header_options() {
        Gson gson = Jsons.getGson();
        CreatePaymentTokenRequest withKey = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .issuer("issuer")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();
        CreatePaymentTokenRequest withoutKey = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .issuer("issuer")
                .build();

        assertEquals(gson.toJson(withoutKey), gson.toJson(withKey));
    }

    @Test
    void header_options_do_not_leak_into_query_params_of_read_requests() {
        SearchProductsRequest request = SearchProductsRequest.builder()
                .name("A new Product")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        String query = RequestQueryParamsBuilder.buildQueryParam(request);

        assertTrue(query.contains("name=A"));
        assertFalse(query.contains("headerOptions"));
        assertFalse(query.contains("idempotencyKey"));
        assertFalse(query.contains("idempotency-key-1"));
    }

    @Test
    void body_request_sends_idempotency_key_header() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        Map<String, String> headers = bodyAdapter.createHeaders(request, "/payment/v1/payment-tokens", requestOptions);

        assertEquals("idempotency-key-1", headers.get(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void body_request_without_key_sends_no_header() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder().value("card-value").build();

        Map<String, String> headers = bodyAdapter.createHeaders(request, "/payment/v1/payment-tokens", requestOptions);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void body_request_with_empty_header_options_sends_no_header() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .headerOptions(HeaderOptions.builder().build())
                .build();

        Map<String, String> headers = bodyAdapter.createHeaders(request, "/payment/v1/payment-tokens", requestOptions);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void read_request_sends_idempotency_key_header_and_stays_body_less() {
        SearchProductsRequest request = SearchProductsRequest.builder()
                .name("A new Product")
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();
        String path = "/craftlink/v1/products" + RequestQueryParamsBuilder.buildQueryParam(request);

        Map<String, String> headers = wrapperAdapter.createHeadersWithoutBody(request, path, requestOptions);

        assertEquals("idempotency-key-1", headers.get(IDEMPOTENCY_KEY_HEADER_NAME));
        assertFalse(path.contains("headerOptions"));
        assertFalse(path.contains("idempotencyKey"));

        String bodyLess = HashGenerator.generateHash(requestOptions.getBaseUrl(), requestOptions.getApiKey(),
                requestOptions.getSecretKey(), headers.get(RANDOM_HEADER_NAME), null, path);
        assertEquals(bodyLess, headers.get(SIGNATURE_HEADER_NAME));
    }

    @Test
    void bodyless_wrapper_sends_idempotency_key_header() {
        DeleteProductRequest request = DeleteProductRequest.builder()
                .id(42L)
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        Map<String, String> headers = wrapperAdapter.createHeadersWithoutBody(request, "/craftlink/v1/products/42", requestOptions);

        assertEquals("idempotency-key-1", headers.get(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void bodyless_wrapper_without_key_sends_no_header() {
        DeleteProductRequest request = DeleteProductRequest.builder().id(42L).build();

        Map<String, String> headers = wrapperAdapter.createHeadersWithoutBody(request, "/craftlink/v1/products/42", requestOptions);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void update_fraud_check_status_wrapper_carries_path_variable_and_key() {
        UpdateFraudCheckStatusRequest request = UpdateFraudCheckStatusRequest.builder()
                .id(2613L)
                .checkStatus(FraudCheckStatus.FRAUD)
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        assertEquals(2613L, request.getId());
        assertEquals(FraudCheckStatus.FRAUD, request.getCheckStatus());
        assertEquals("idempotency-key-1", request.getHeaderOptions().getIdempotencyKey());
    }

    @Test
    void update_fraud_check_status_body_carries_only_the_status() {
        Gson gson = Jsons.getGson();
        UpdateFraudCheckStatusRequest request = UpdateFraudCheckStatusRequest.builder()
                .id(2613L)
                .checkStatus(FraudCheckStatus.FRAUD)
                .headerOptions(idempotencyKey("idempotency-key-1"))
                .build();

        String json = gson.toJson(request);

        assertEquals("{\"checkStatus\":\"FRAUD\"}", json);
        assertEquals(2613L, request.getId());
        assertEquals("idempotency-key-1", request.getHeaderOptions().getIdempotencyKey());
    }
}
