package io.craftgate.request.common;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.time.LocalDateTime;

public final class Jsons {

    private static final ExclusionStrategy EXCLUDE_HEADER_OPTIONS = new ExclusionStrategy() {

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return HeaderOptions.class.equals(clazz);
        }

        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return false;
        }
    };

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (localDateTime, typeOfSrc, context) ->
                    context.serialize(localDateTime.toString()))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                    LocalDateTime.parse(json.getAsString()))
            .addSerializationExclusionStrategy(EXCLUDE_HEADER_OPTIONS)
            .create();

    private Jsons() {
    }

    public static Gson getGson() {
        return GSON;
    }
}