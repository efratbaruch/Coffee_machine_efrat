package beverages;

import orderComponents.Ingredients;

import java.util.HashMap;

public class Latte implements Beverage {

    private HashMap<Ingredients, Integer> latteIngredients = new HashMap<>();

    Latte() {
        latteIngredients.put(Ingredients.WATER, 1);
        latteIngredients.put(Ingredients.COFFEE_BEANS, 1);
        latteIngredients.put(Ingredients.MILK, 2);
        latteIngredients.put(Ingredients.SUGAR, 1);
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredients() {
        return latteIngredients;
    }
}
