package stock;

import orderComponents.Ingredients;

import java.util.HashMap;

public class StockManager {

    private HashMap<Ingredients, Integer> stock = new HashMap<>();

    private static final StockManager INSTANCE = new StockManager();

    //todo: make quantity constant
    private StockManager() {
        for (Ingredients ingredients : Ingredients.values()){
            stock.put(ingredients, 20);
        }
    }

    public static StockManager getInstance(){
        return INSTANCE;
    }

    public HashMap<Ingredients, Integer> getStock() {
        return stock;
    }

    //todo: either refill when necessary or refill every num of orders
    void stockInspection() {

    }

    //todo: num for which I would refill should be constant and perhaps no logic here in inspection
    public void refillIngredient(Ingredients ingredient){
        if (stock.get(ingredient)<=5){
            stock.put(ingredient, 20-stock.get(ingredient));
        }
    }
}
