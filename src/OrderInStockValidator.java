import java.util.HashMap;

class OrderInStockValidator implements Validator {

    @Override
    public boolean validate (Order order) {
        return verifyIngredientsInStock(getIngredients(order));
    }

    private HashMap<Ingredients, Integer> getIngredients (Order order) {
        CoffeeMixer coffeeMixer = new CoffeeMixer(order);
        return coffeeMixer.getMixedIngredients();
    }

    private boolean verifyIngredientsInStock (HashMap<Ingredients, Integer> ingredients) {

        for(Ingredients ingredient: ingredients.keySet()){

            int quantityInStock = StockManager.STOCK.get(ingredient);

            if (quantityInStock<ingredients.get(ingredient)){
                orderNotInStock(ingredient);
                return false;
            }
            else if (quantityInStock==ingredients.get(ingredient)){
                notifyEmptyTank(ingredient);
            }
        }
        return true;
    }

    //todo: has to be the responsibility of an api method?
    private void orderNotInStock (Ingredients ingredients) {
        System.out.println("Not enough " + ingredients.toString().toLowerCase() + " in stock for your order!");
    }

    //todo
    private void notifyEmptyTank (Ingredients ingredients) {

    }

}
