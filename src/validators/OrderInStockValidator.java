package validators;

import orderComponents.Ingredients;
import orderComponents.Order;
import ordermaking.CoffeeMixer;
import stock.StockManager;

import java.util.HashMap;

public class OrderInStockValidator implements Validator {

    private StockManager stockManager = StockManager.getInstance();

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

            int quantityInStock = stockManager.getStock().get(ingredient);

            if (quantityInStock<ingredients.get(ingredient)){
                orderNotInStock(ingredient);
                return false;
            }
            //todo: I don't like it this way. either make one or allocate responsibility outside
            else if (quantityInStock-ingredients.get(ingredient)<=5 && quantityInStock-ingredients.get(ingredient)>=0){
                notifyEmptyOrLowTank(ingredient);
            }
            else if (quantityInStock==ingredients.get(ingredient)){
                notifyEmptyOrLowTank(ingredient);
            }
        }
        return true;
    }

    //todo: has to be the responsibility of an api method?
    private void orderNotInStock (Ingredients ingredients) {
        System.out.println("Not enough " + ingredients.toString().toLowerCase() + " in stock for your order!");
    }

    //todo
    private void notifyEmptyOrLowTank(Ingredients ingredient) {
        stockManager.refillIngredient(ingredient);
    }

}
