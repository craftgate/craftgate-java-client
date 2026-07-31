package io.craftgate.request.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {

    private transient String idempotencyKey;

    public HeaderOptions toHeaderOptions(){
        return HeaderOptions.builder()
                .idempotencyKey(idempotencyKey)
                .build();
    }
}
