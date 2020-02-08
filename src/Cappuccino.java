import java.util.HashMap;

class Cappuccino implements Beverage {

    private HashMap<Ingredients, Integer> cappuccinoIngredients = new HashMap<>();

    Cappuccino(){
        cappuccinoIngredients.put(Ingredients.WATER, 2);
        cappuccinoIngredients.put(Ingredients.COFFEE_BEANS, 2);
        cappuccinoIngredients.put(Ingredients.MILK, 3);
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredients(){
        return cappuccinoIngredients;
    }
}
