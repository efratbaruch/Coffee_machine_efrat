package userinterface;

import java.util.Scanner;

public class OrderCloser {

    public boolean closeOrder() {
        boolean anotherOrder = false;

        System.out.println("Order complete. Do you want to make another order? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String customerResponse = scanner.nextLine();

        try {
            anotherOrder = customerResponse.equalsIgnoreCase("yes");
        } catch (NullPointerException e) {
            System.out.println("Invalid input!");
            new OrderCloser().closeOnError();
        }

        return anotherOrder;
    }

    public void closeCoffeeMachine() {
        System.out.println("Goodbye!");
    }

    void closeOnError() {
        System.out.println("Goodbye!");
        System.exit(1);
    }
}
