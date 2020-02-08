import java.util.HashMap;

class Black implements Beverage {

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
