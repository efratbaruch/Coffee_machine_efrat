package ordermaking;

import stock.StockManager;
import userinterface.OrderCloser;
import userinterface.OrderDelivery;
import userinterface.OrderReceiver;
import orderComponents.Order;
import validators.OrderValidator;
import validators.Validator;
import validators.ValidatorsManager;

import java.util.ArrayList;

public class OrderManager {

    private int numberOfConsecutiveOrders = 0;
    private final int NUM_TRIGGER_INSPECTION = 5;

    public void getAndDeliverOrder() {

        verifyStock();

        Order order = takeOrder();

        if (validateOrder(order, getValidatorList())) {
            new OrderDelivery().deliverOrder(order);
        }

        closeOrder();
    }

    private ArrayList<Validator> getValidatorList() {
        return new ValidatorsManager().getValidatorList();
    }

    private Order takeOrder() {
        return new OrderReceiver().assembleOrder();
    }

    private boolean validateOrder(Order order, ArrayList<Validator> validatorList) {
        return new OrderValidator(order, validatorList).validateOrder();
    }

    private void closeOrder() {
        if (new OrderCloser().closeOrder()) {
            numberOfConsecutiveOrders++;
            getAndDeliverOrder();
        } else {
            new OrderCloser().closeCoffeeMachine();
        }
    }

    private void verifyStock() {
        if (numberOfConsecutiveOrders == NUM_TRIGGER_INSPECTION) {
            StockManager.getInstance().stockInspection();
        }
    }

}
