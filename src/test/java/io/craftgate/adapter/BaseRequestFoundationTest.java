package io.craftgate.adapter;

import com.google.gson.Gson;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.request.DeleteProductRequest;
import io.craftgate.request.SearchProductsRequest;
import io.craftgate.request.common.Jsons;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseRequestFoundationTest {

    private static final String IDEMPOTENCY_KEY_HEADER_NAME = "x-idempotency-key";

    private final RequestOptions requestOptions = RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build();

    private final PaymentTokenAdapter bodyAdapter = new PaymentTokenAdapter(requestOptions);
    private final PayByLinkAdapter wrapperAdapter = new PayByLinkAdapter(requestOptions);

    @Test
    void superbuilder_includes_inherited_idempotency_key() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .issuer("issuer")
                .idempotencyKey("idempotency-key-1")
                .build();

        assertEquals("idempotency-key-1", request.getIdempotencyKey());
        assertEquals("card-value", request.getValue());
    }

    @Test
    void idempotency_key_is_excluded_from_serialized_body_and_signature() {
        Gson gson = Jsons.getGson();
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .idempotencyKey("idempotency-key-1")
                .build();

        String json = gson.toJson(request);

        assertTrue(json.contains("card-value"));
        assertFalse(json.contains("idempotencyKey"));
        assertFalse(json.contains("idempotency-key-1"));
    }

    @Test
    void idempotency_key_does_not_leak_into_query_params_of_read_requests() {
        SearchProductsRequest request = SearchProductsRequest.builder()
                .name("A new Product")
                .idempotencyKey("idempotency-key-1")
                .build();

        String query = RequestQueryParamsBuilder.buildQueryParam(request);

        assertTrue(query.contains("name=A"));
        assertFalse(query.contains("idempotencyKey"));
        assertFalse(query.contains("idempotency-key-1"));
    }

    @Test
    void body_request_sends_idempotency_key_header() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("card-value")
                .idempotencyKey("idempotency-key-1")
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
    void bodyless_wrapper_sends_idempotency_key_header() {
        DeleteProductRequest request = DeleteProductRequest.builder()
                .id(42L)
                .idempotencyKey("idempotency-key-1")
                .build();

        Map<String, String> headers = wrapperAdapter.createHeaders("/craftlink/v1/products/42", requestOptions, request);

        assertEquals("idempotency-key-1", headers.get(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void bodyless_wrapper_without_key_sends_no_header() {
        DeleteProductRequest request = DeleteProductRequest.builder().id(42L).build();

        Map<String, String> headers = wrapperAdapter.createHeaders("/craftlink/v1/products/42", requestOptions, request);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }
}
