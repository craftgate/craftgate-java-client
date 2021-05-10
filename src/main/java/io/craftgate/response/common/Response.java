package io.craftgate.response.common;

import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class Response {

    private ErrorResponse errors;
    private JsonObject data;
}
