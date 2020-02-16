package stock;

public class StockManagerProvider {

    private static StockManager stockManager;

    public static StockManager get() {
        if (stockManager == null) {
            stockManager = new StockManager();
        }
        return stockManager;
    }
}
