package io.craftgate.model;

public enum RefundDestinationType {

    /**
     * @deprecated use @{@link RefundDestinationType#PROVIDER} instead.
     */
    @Deprecated CARD,
    PROVIDER,
    WALLET
}
