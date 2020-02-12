package userinterface;

import orderComponents.Order;
import ordermaking.OrderMaker;

public class OrderDelivery {

    public void deliverOrder(Order order) {
        System.out.println(new OrderMaker().prepareOrder(order));
    }

    public void notifyOrderNotInStock() {
        System.out.println("Unfortunately, your order in not in stock.");
    }
}
