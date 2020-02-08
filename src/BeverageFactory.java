class BeverageFactory {

    //todo: add default

    Beverage getBeverage(Beverages beverages) {
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

