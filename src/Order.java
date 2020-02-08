import java.util.ArrayList;

class Order {

    Beverages beverage;
    int sugar;
    boolean milk;
    CupSize size;

    Order (Beverages beverage, int sugar, boolean milk, CupSize size){
        this.beverage = beverage;
        this.sugar = sugar;
        this.milk = milk;
        this.size = size;
    }

    ArrayList<String> getOrderList (){

        ArrayList<String> orderList = new ArrayList<>();

        orderList.add(getOrderSize());
        orderList.add(getOrderBeverage());
        orderList.add(getOrderMilk());
        orderList.add(getOrderSugar());

        return orderList;
    }


    private String getOrderBeverage (){
        String orderBeverage = beverage.toString().toLowerCase();
        return orderBeverage.substring(0, 1).toUpperCase() + orderBeverage.substring(1);
    }

    private String getOrderSugar() {
        if (sugar == 0) {
            return "no sugar";
        } else {
            return sugar + " cubes of sugar";
        }
    }

    private String getOrderMilk() {
        if (milk) {
            return "milk";
        } else {
            return "no milk";
        }
    }

    // todo: default?
    private String getOrderSize() {
        switch (size) {
            case SMALL:
                return "small";
            case MEDIUM:
                return "medium";
            case LARGE:
                return "large";
            default:
                return "regular";
        }
    }

}
