package runners;

import ordermaking.OrderManager;

public class CoffeeMachineRunner {

    public static void main(String[] args) {

        new OrderManager().getAndDeliverOrder();

    }
}
