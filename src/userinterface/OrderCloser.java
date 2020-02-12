package userinterface;

import java.util.Scanner;

public class OrderCloser {

    //todo: search for exception protection for whole project: from outside

    public boolean closeOrder() {
        System.out.println("Order complete. Do you want to make another order? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String customerResponse = scanner.nextLine();

        return customerResponse.equalsIgnoreCase("yes");
    }

    public void closeCoffeeMachine() {
        System.out.println("Goodbye!");
    }

    public void closeOnError() {
        System.out.println("Goodbye!");
        System.exit(1);
    }
}
