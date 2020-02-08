import java.util.HashMap;

class Espresso implements Beverage {

    private HashMap <Ingredients, Integer> espressoIngredients = new HashMap<>();

    Espresso(){
        espressoIngredients.put(Ingredients.WATER, 1);
        espressoIngredients.put(Ingredients.COFFEE_BEANS, 2);
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredients(){
        return espressoIngredients;
    }
}
