package validators;

import orderComponents.Ingredients;
import orderComponents.Order;
import ordermaking.IngredientsMixer;
import stock.StockManager;
import userinterface.OrderDelivery;

import java.util.HashMap;

public class OrderInStockValidator implements Validator {

    private StockManager stockManager = StockManager.getInstance();

    @Override
    public boolean validate(Order order) {
        return verifyIngredientsInStock(getIngredients(order));
    }

    private HashMap<Ingredients, Integer> getIngredients(Order order) {
        IngredientsMixer ingredientsMixer = new IngredientsMixer(order);
        return ingredientsMixer.getMixedIngredients();
    }

    private boolean verifyIngredientsInStock(HashMap<Ingredients, Integer> ingredients) {
        for (Ingredients ingredient : ingredients.keySet()) {
            int quantityInStock = stockManager.getStock().get(ingredient);

            if (quantityInStock < ingredients.get(ingredient)) {
                orderNotInStock();
                return false;
            } else if (quantityInStock == ingredients.get(ingredient)) {
                notifyEmptyTank(ingredient);
            }
        }
        return true;
    }

    private void orderNotInStock() {
        new OrderDelivery().notifyOrderNotInStock();
    }

    private void notifyEmptyTank(Ingredients ingredient) {
        stockManager.refillIngredient(ingredient);
    }
}
