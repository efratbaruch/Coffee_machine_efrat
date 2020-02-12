package ordermaking;

import orderComponents.Order;

import java.util.ArrayList;

public class OrderMaker {

    public String prepareOrder(Order order) {

        ArrayList<String> orderList = order.getOrderList();

        StringBuilder preparedOrder = new StringBuilder("Here you go! A");

        for (String orderComponent : orderList) {
            if (orderList.indexOf(orderComponent) == 0 || orderList.indexOf(orderComponent) == 1) {
                preparedOrder.append(" ").append(orderComponent);
            } else if (orderList.indexOf(orderComponent) == orderList.size() - 1) {
                preparedOrder.append(" and with ").append(orderComponent).append(".");
            } else {
                preparedOrder.append(", with ").append(orderComponent);
            }
        }

        return preparedOrder.toString();
    }

}
