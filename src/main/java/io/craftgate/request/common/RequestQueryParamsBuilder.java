package io.craftgate.request.common;

import lombok.Data;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class RequestQueryParamsBuilder {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final String EMPTY = "";
    private static final String PLUS_CHAR = "+";
    private static final String PLUS_REPLACEMENT_CHAR = "%20";

    public static String buildQueryParam(Object object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            StringBuilder query = new StringBuilder(fields.length > 0 ? "?" : "");

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);

                if (Objects.nonNull(value)) {
                    query.append(field.getName()).append("=").append(URLEncoder.encode(formatValue(value))).append("&");
                }
            }

            return query.toString().replace(PLUS_CHAR, PLUS_REPLACEMENT_CHAR);
        } catch (Exception e) {
            return EMPTY;
        }
    }

    private static String formatValue(Object value) {
        if (value instanceof LocalDateTime) return formatDateValue((LocalDateTime) value);
        if (value instanceof Collection) return formatCollectionValue((Collection<Object>) value);
        return value.toString();
    }

    private static String formatDateValue(LocalDateTime date) {
        return DATE_TIME_FORMATTER.format(date);
    }

    private static String formatCollectionValue(Collection<Object> value) {
        return value.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
