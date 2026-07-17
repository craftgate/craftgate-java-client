package io.craftgate.adapter;

import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BaseAdapterTest {

    private static final String IDEMPOTENCY_KEY_HEADER_NAME = "x-idempotency-key";

    private final RequestOptions requestOptions = RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build();

    @Test
    void should_not_add_idempotency_key_header_by_default() {
        PaymentAdapter adapter = new PaymentAdapter(requestOptions);

        Map<String, String> headers = adapter.createHeaders("/payment/v1/card-payments", requestOptions);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void should_add_idempotency_key_header_when_request_context_given() {
        RequestContext requestContext = RequestContext.builder()
                .idempotencyKey("idempotency-key-1")
                .build();

        PaymentAdapter adapter = new PaymentAdapter(requestOptions).withRequestContext(requestContext);

        Map<String, String> headers = adapter.createHeaders("/payment/v1/card-payments", requestOptions);

        assertEquals("idempotency-key-1", headers.get(IDEMPOTENCY_KEY_HEADER_NAME));
    }

    @Test
    void should_not_affect_original_adapter_when_request_context_given() {
        PaymentAdapter adapter = new PaymentAdapter(requestOptions);
        adapter.withRequestContext(RequestContext.builder().idempotencyKey("idempotency-key-1").build());

        Map<String, String> headers = adapter.createHeaders("/payment/v1/card-payments", requestOptions);

        assertFalse(headers.containsKey(IDEMPOTENCY_KEY_HEADER_NAME));
    }
}
