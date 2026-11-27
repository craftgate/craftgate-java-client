package io.craftgate.model;

public enum TransactionPayoutStatus {

    CANCELLED,
    ELIMINATED_BY_FULLY_REFUND,
    NO_PAYOUT,
    WAITING_FOR_PAYOUT,
    PAYOUT_STARTED,
    PAYOUT_COMPLETED
}
