package io.craftgate.model;

public enum WalletTransactionType {

    PAYMENT_REDEEM,
    REFUND_DEPOSIT,
    REFUND_TX_DEPOSIT,
    CANCEL_REFUND_TO_WALLET,
    REFUND_TX_TO_WALLET,
    MANUAL_REFUND_TX_TO_WALLET,
    DEPOSIT_FROM_CARD,
    REMITTANCE,
    LOYALTY
}
