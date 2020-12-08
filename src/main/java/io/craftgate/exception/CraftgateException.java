package io.craftgate.exception;

import lombok.Data;

@Data
public class CraftgateException extends RuntimeException {

    private static final String GENERAL_ERROR_CODE = "0";
    private static final String GENERAL_ERROR_DESCRIPTION = "An error occurred.";
    private static final String GENERAL_ERROR_GROUP = "Unknown";
    private final String errorCode;
    private final String errorDescription;
    private final String errorGroup;

    public CraftgateException() {
        super(GENERAL_ERROR_DESCRIPTION);
        this.errorCode = GENERAL_ERROR_CODE;
        this.errorDescription = GENERAL_ERROR_DESCRIPTION;
        this.errorGroup = GENERAL_ERROR_GROUP;
    }

    public CraftgateException(String errorCode, String errorDescription, String errorGroup) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorGroup = errorGroup;
    }

    public CraftgateException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.errorCode = GENERAL_ERROR_CODE;
        this.errorDescription = GENERAL_ERROR_DESCRIPTION;
        this.errorGroup = GENERAL_ERROR_GROUP;
    }
}
