import java.util.HashMap;

public class StockManager {

    public static HashMap<Ingredients, Integer> STOCK = new HashMap<>();

    public static StockManager instance = new StockManager();

    //todo: make quantity constant
    private StockManager() {
        for (Ingredients ingredients : Ingredients.values()){
            STOCK.put(ingredients, 20);
        }
    }

    public StockManager getInstance(){
        return instance;
    }

    //todo
    void stockInspection() {

    }

}
