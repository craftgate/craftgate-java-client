package io.craftgate.model;

public enum ApmAdditionalAction {
    REDIRECT_TO_URL,

    OTP_REQUIRED,
    WAIT_FOR_WEBHOOK,
    APPROVAL_REQUIRED,
    NONE
}