package beverages;

import orderComponents.Ingredients;
import java.util.HashMap;

public interface Beverage {

    HashMap<Ingredients, Integer> getIngredients();
}
