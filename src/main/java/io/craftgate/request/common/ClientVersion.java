package io.craftgate.request.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ClientVersion {

    private static final String UNKNOWN = "unknown";
    private static final String VERSION = readVersion();

    private ClientVersion() {
    }

    public static String get() {
        return VERSION;
    }

    private static String readVersion() {
        try (InputStream inputStream = ClientVersion.class.getResourceAsStream("/io/craftgate/craftgate-version.properties")) {
            if (inputStream == null) {
                return UNKNOWN;
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            String version = properties.getProperty("version");
            if (version == null || version.isEmpty() || version.startsWith("${") || "unspecified".equals(version)) {
                return UNKNOWN;
            }
            return version;
        } catch (IOException e) {
            return UNKNOWN;
        }
    }
}
