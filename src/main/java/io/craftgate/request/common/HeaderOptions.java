package io.craftgate.request.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HeaderOptions {
    private String idempotencyKey;
}
