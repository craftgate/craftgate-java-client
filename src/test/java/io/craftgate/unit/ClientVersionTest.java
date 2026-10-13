package io.craftgate.unit;

import io.craftgate.request.common.ClientVersion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientVersionTest {

    @Test
    void should_read_client_version_from_build() {
        //given
        String expectedVersion = System.getProperty("craftgate.expectedVersion", "unknown");

        //when
        String version = ClientVersion.get();

        //then
        assertEquals(expectedVersion, version);
    }
}
