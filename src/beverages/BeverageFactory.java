package beverages;

import beverages.*;

public class BeverageFactory {

    //todo: add default parameter?
    //todo: check all switch cases for breaks

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
                return new Espresso();
        }
    }
}

