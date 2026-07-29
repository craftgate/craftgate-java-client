package io.craftgate.request.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Base class for request objects sent to the Craftgate API.
 *
 * <p>Holds request-scoped options that are transmitted as headers rather than in the
 * request body. Fields declared here are {@code transient} so that they are excluded from
 * both the JSON body and the request signature. The class is intentionally generic so that
 * other request-scoped options (e.g. a per-request language override) can be added here in
 * the future and reused by any request that extends it.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {

    /**
     * Optional idempotency key. When set on a request to a mutating endpoint (POST/PUT/DELETE),
     * it is sent as the {@code x-idempotency-key} header so the operation can be safely retried.
     */
    private transient String idempotencyKey;
}
