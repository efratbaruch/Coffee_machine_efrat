package ordermaking;

import beverages.BeverageFactory;
import orderComponents.Ingredients;
import orderComponents.Order;

import java.util.HashMap;

public class IngredientsMixer {

    private Order order;
    private HashMap<Ingredients, Integer> ingredientMap;

    public IngredientsMixer(Order order) {
        this.order = order;
    }

    public HashMap<Ingredients, Integer> getMixedIngredients() {
        addIngredientsOfBeverage();
        addWaterIngredient();
        addMilkIngredient();
        addSugarIngredient();

        return ingredientMap;
    }

    private void addIngredientsOfBeverage() {
        ingredientMap = new BeverageFactory().getBeverage(order.beverage).getIngredients();
    }

    private void addWaterIngredient() {
        switch (order.size) {
            case SMALL:
                if (ingredientMap.containsKey(Ingredients.WATER)) {
                    break;
                } else {
                    ingredientMap.put(Ingredients.WATER, 1);
                }
                break;
            case MEDIUM:
                if (ingredientMap.containsKey(Ingredients.WATER)) {
                    ingredientMap.put(Ingredients.WATER, ingredientMap.get(Ingredients.WATER) + 1);
                } else {
                    ingredientMap.put(Ingredients.WATER, 1);
                }
                break;
            case LARGE:
                if (ingredientMap.containsKey(Ingredients.WATER)) {
                    ingredientMap.put(Ingredients.WATER, ingredientMap.get(Ingredients.WATER) + 2);
                } else {
                    ingredientMap.put(Ingredients.WATER, 2);
                }
                break;
        }
    }

    private void addMilkIngredient() {
        if (order.milk) {
            if (ingredientMap.containsKey(Ingredients.MILK)) {
                ingredientMap.put(Ingredients.MILK, ingredientMap.get(Ingredients.MILK) + 1);
            } else {
                ingredientMap.put(Ingredients.MILK, 1);
            }
        }
    }

    private void addSugarIngredient() {
        if (ingredientMap.containsKey(Ingredients.SUGAR)) {
            ingredientMap.put(Ingredients.SUGAR, ingredientMap.get(Ingredients.SUGAR) + order.sugar);
        } else {
            ingredientMap.put(Ingredients.SUGAR, order.sugar);
        }
    }

}
