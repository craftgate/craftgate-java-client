package io.craftgate.model;

public enum WebhookEventType {

    API_AUTH,
    API_VERIFY_AND_AUTH,
    CHECKOUTFORM_AUTH,
    THREEDS_VERIFY,
    REFUND,
    REFUND_TX,
    PAYOUT_COMPLETED,
    AUTOPILOT,
    WALLET_CREATED,
    WALLET_TX_CREATED,
    BNPL_NOTIFICATION
}
