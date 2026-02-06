package io.craftgate.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CraftgateException extends RuntimeException {

    private static final String GENERAL_ERROR_CODE = "0";
    private static final String GENERAL_ERROR_DESCRIPTION = "An error occurred.";
    private static final String GENERAL_ERROR_GROUP = "Unknown";

    private final String errorCode;
    private final String errorDescription;
    private final String errorGroup;
    private final String providerErrorCode;
    private final String providerErrorDescription;

    public CraftgateException() {
        super(GENERAL_ERROR_DESCRIPTION);
        this.errorCode = GENERAL_ERROR_CODE;
        this.errorDescription = GENERAL_ERROR_DESCRIPTION;
        this.errorGroup = GENERAL_ERROR_GROUP;
        this.providerErrorCode = null;
        this.providerErrorDescription = null;
    }

    public CraftgateException(String errorCode, String errorDescription, String errorGroup) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorGroup = errorGroup;
        this.providerErrorCode = null;
        this.providerErrorDescription = null;
    }

    public CraftgateException(String errorCode, String errorDescription, String errorGroup,
            String providerErrorCode, String providerErrorDescription) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorGroup = errorGroup;
        this.providerErrorCode = providerErrorCode;
        this.providerErrorDescription = providerErrorDescription;
    }

    public CraftgateException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.errorCode = GENERAL_ERROR_CODE;
        this.errorDescription = GENERAL_ERROR_DESCRIPTION;
        this.errorGroup = GENERAL_ERROR_GROUP;
        this.providerErrorCode = null;
        this.providerErrorDescription = null;
    }
}
