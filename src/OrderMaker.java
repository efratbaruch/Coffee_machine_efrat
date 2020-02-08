import java.util.ArrayList;

public class OrderMaker {

    //todo: search for exception protection for whole project

    String prepareOrder(Order order) {

        ArrayList<String> orderList = order.getOrderList();

        StringBuilder preparedOrder = new StringBuilder("Here you go! A");

        for (String orderComponent : orderList){
            if (orderList.indexOf(orderComponent)==0 || orderList.indexOf(orderComponent)==1){
                preparedOrder.append(" " + orderComponent);
            }
            else if (orderList.indexOf(orderComponent)==orderList.size()-1){
                preparedOrder.append(" and with " + orderComponent + ".");
            }
            else {
                preparedOrder.append(", with " + orderComponent);
            }
        }

        return preparedOrder.toString();
    }

}
