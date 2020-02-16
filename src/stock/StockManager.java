package stock;

import orderComponents.Ingredients;

import java.util.HashMap;

public class StockManager {

    private HashMap<Ingredients, Integer> stock = new HashMap<>();

    private final int INITIAL_STOCK_QUANTITY = 20;
    private final int MINIMUM_INGREDIENT_QUANTITY = 5;

    StockManager() {
        for (Ingredients ingredient : Ingredients.values()) {
            stock.put(ingredient, INITIAL_STOCK_QUANTITY);
        }
    }

    public HashMap<Ingredients, Integer> getStock() {
        return stock;
    }

    public void stockInspection() {
        for (Ingredients ingredient : Ingredients.values()) {
            if (stock.get(ingredient) < MINIMUM_INGREDIENT_QUANTITY) {
                refillIngredient(ingredient);
            }
        }
    }

    public void refillIngredient(Ingredients ingredient) {
        stock.put(ingredient, INITIAL_STOCK_QUANTITY - stock.get(ingredient));
    }
}
