package beverages;

import orderComponents.Ingredients;

import java.util.HashMap;

public class Black implements Beverage {

    private HashMap<Ingredients, Integer> blackIngredients = new HashMap<>();

    Black(){
        blackIngredients.put(Ingredients.WATER, 1);
        blackIngredients.put(Ingredients.COFFEE_BEANS, 3);
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredients(){
        return blackIngredients;
    }
}
