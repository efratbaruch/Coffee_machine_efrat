package beverages;

import orderComponents.Ingredients;

import java.util.HashMap;

public class Tea implements Beverage {

    private HashMap<Ingredients, Integer> teaIngredients = new HashMap<>();

    Tea() {
        teaIngredients.put(Ingredients.WATER, 2);
        teaIngredients.put(Ingredients.TEA_BUG, 1);
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredients() {
        return teaIngredients;
    }
}
