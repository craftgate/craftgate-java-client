package io.craftgate.model;

public enum CardBrand {
    BONUS("Bonus"),
    AXESS("Axess"),
    MAXIMUM("Maximum"),
    WORLD("World"),
    PARAF("Paraf"),
    CARD_FINANS("CardFinans"),
    BANKKART_COMBO("Bankkart Combo"),
    ADVANTAGE("Advantage"),
    SAGLAM_KART("Sağlam Kart");

    private final String cardBrandName;

    CardBrand(String cardBrandName) {
        this.cardBrandName = cardBrandName;
    }

    public String toName() {
        return this.cardBrandName;
    }
}
