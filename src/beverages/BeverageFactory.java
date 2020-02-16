package beverages;

public class BeverageFactory {

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
            default:
            case TEA:
                return new Tea();
        }
    }
}

