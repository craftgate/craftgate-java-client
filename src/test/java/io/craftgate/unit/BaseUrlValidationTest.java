package io.craftgate.unit;

import io.craftgate.Craftgate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseUrlValidationTest {

    @Test
    void accepts_https_and_loopback_http_base_urls() {
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "HTTPS://api.craftgate.io"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "http://localhost:8000"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "http://127.0.0.1:8000"));
    }

    @Test
    void rejects_insecure_or_invalid_base_urls() {
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "http://api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "http://localhost.evil.com"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "ftp://api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", (String) null));
    }
}
