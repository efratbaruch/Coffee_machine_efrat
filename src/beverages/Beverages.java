package beverages;

public enum Beverages {

    ESPRESSO,
    BLACK,
    CAPPUCCINO,
    LATTE,
    TEA;

    @Override
    public String toString() {
        String string = super.toString();
        return string.substring(0, 1) + string.substring(1).toLowerCase();
    }
}

