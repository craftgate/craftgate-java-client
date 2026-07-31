package io.craftgate.request.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Base class for request objects sent to the Craftgate API. Fields here are {@code transient},
 * which keeps them out of the body, the signature and the query string.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {

    /**
     * Optional key, sent as the {@code x-idempotency-key} header so a mutating call can be safely
     * retried.
     */
    private transient String idempotencyKey;

    public HeaderOptions toHeaderOptions(){
        return HeaderOptions.builder()
                .idempotencyKey(idempotencyKey)
                .build();
    }
}
