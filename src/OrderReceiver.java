import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderReceiver {

    //todo: do the tearDown trick?
    Order assembleOrder() {

        offerCoffeeVariety();

        Beverages beverages = getCoffeeType();

        offerCoffeeSize();

        CupSize cupSize = getCoffeeSize();

        int sugarAmount = getSugarAmount();

        boolean milkPreference = getMilkPreference();

        return new Order(beverages, sugarAmount, milkPreference, cupSize);
    }

    private void offerCoffeeVariety() {

        System.out.println("What would you like to drink? Here is a list of beverages:");

        for (Beverages beverages : Beverages.values()){
            System.out.println(beverages);
        }
    }

    private void offerCoffeeSize() {

        System.out.println("What coffee size would you like? Here is a list of options:");

        for (CupSize cupSize : CupSize.values()) {
            System.out.println(cupSize);
        }
    }

    // todo: see if I should separate parts of method.
    private Beverages getCoffeeType() {

        boolean correctCoffeeType = true;
        Beverages chosenBeverages = Beverages.ESPRESSO;
        int orderTriesCounter = 0;

        do {

            System.out.println("Please type your coffee order:");

            Scanner scanner = new Scanner(System.in);
            String coffeeType = scanner.nextLine();

            for (Beverages beverage : Beverages.values()) {

                correctCoffeeType = coffeeType.equalsIgnoreCase(beverage.toString());

                if (correctCoffeeType){
                    return beverage;
                }
            }

            orderTriesCounter ++;

            if (orderTriesCounter>5){
                System.out.println("Too many invalid order attempts. Goodbye!");
                break;
                //todo: see if I sould add a system shutdown method.
            }

            System.out.println("Invalid input, please try again.");

        }
        while (!correctCoffeeType);

        return chosenBeverages;
    }

    private int getSugarAmount() {

        int sugarAmount = 0;
        boolean invalidInput = false;
        int orderTriesCounter = 0;

        do {
            System.out.println("How many sugar cubes would you like in your coffee?");

            Scanner scanner = new Scanner(System.in);

            try {
                sugarAmount = scanner.nextInt();
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                invalidInput = true;
            }

            orderTriesCounter ++;

            if (orderTriesCounter>5){
                System.out.println("Too many invalid order attempts. Goodbye!");
                break;
                //todo: see if I should add a system shutdown method.
            }

        }
        while (invalidInput);

        return sugarAmount;
    }

    private boolean getMilkPreference() {

        boolean addMilk = false;
        boolean invalidOrder = true;
        int orderTriesCounter = 0;

        do {
            System.out.println("Do you want to add milk to your order? (yes/no)");

            Scanner scanner = new Scanner(System.in);
            String milkResponse = scanner.nextLine();

            //todo: protect from null-pointer
            switch (milkResponse.toLowerCase()) {
                case "yes":
                    addMilk = true;
                    invalidOrder = false;
                    break;
                case "no":
                    addMilk = false;
                    invalidOrder = false;
                    break;
            }

            orderTriesCounter++;

            if (orderTriesCounter > 5) {
                System.out.println("Too many invalid order attempts. Goodbye!");
                break;
                //todo: I should add a system shutdown method.
            }

            if (invalidOrder){
                System.out.println("Invalid input, please try again.");
            }
        }
        while (invalidOrder);

        return addMilk;
    }

    private CupSize getCoffeeSize() {

        boolean correctCoffeeSize = true;
        CupSize chosenCupSize = CupSize.MEDIUM;
        int orderTriesCounter = 0;

        do {

            System.out.println("Please enter your coffee size choice:");

            Scanner scanner = new Scanner(System.in);
            String coffeeType = scanner.nextLine();

            for (CupSize cupSize : CupSize.values()) {
                correctCoffeeSize = coffeeType.equalsIgnoreCase(cupSize.toString());

                if (correctCoffeeSize){
                    return cupSize;
                }
            }

            orderTriesCounter ++;

            if (orderTriesCounter>5){
                System.out.println("Too many invalid order attempts. Goodbye!");
                break;
                //todo: see if I sould add a system shutdown method.
            }

            System.out.println("Invalid input, please try again.");

        }
        while (!correctCoffeeSize);

        return chosenCupSize;
    }

    boolean closeOrder () {
        System.out.println("Order complete. Do you want to make another order? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String customerResponse = scanner.nextLine();

        return customerResponse.equalsIgnoreCase("yes");
    }

    void closeCoffeeMachine () {
        System.out.println("Goodbye!");
    }
}