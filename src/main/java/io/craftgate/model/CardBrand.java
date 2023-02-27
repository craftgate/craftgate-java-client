package io.craftgate.model;

public enum CardBrand {
    Bonus("Bonus"),
    Axess("Axess"),
    Maximum("Maximum"),
    World("World"),
    Paraf("Paraf"),
    CardFinans("CardFinans"),
    BankkartCombo("Bankkart Combo"),
    Advantage("Advantage"),
    SaglamKart("Sağlam Kart");

    private final String cardBrandName;

    CardBrand(String cardBrandName) {
        this.cardBrandName = cardBrandName;
    }

    public String toName() {
        return this.cardBrandName;
    }
}
