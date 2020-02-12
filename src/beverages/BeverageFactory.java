package beverages;

public class BeverageFactory {

    private static final Beverage DEFAULT_BEVERAGE = new Espresso();

    public Beverage getBeverage(Beverages beverages) {
        switch (beverages) {
            case ESPRESSO:
                return new Espresso();
            case BLACK:
                return new Black();
            case LATTE:
                return new Latte();
            case CAPPUCCINO:
                return new Cappuccino();
            case TEA:
                return new Tea();
            default:
                return DEFAULT_BEVERAGE;
        }
    }
}

