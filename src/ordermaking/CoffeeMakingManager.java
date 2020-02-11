package ordermaking;

import apimethods.OrderReceiver;
import orderComponents.Order;
import validators.OrderInStockValidator;
import validators.OrderValidator;
import validators.Validator;

import java.util.ArrayList;

public class CoffeeMakingManager {

    public void getAndDeliverOrder(){

        Order order = takeOrder();

        if(validateOrder(order, getValidatorList())){
            System.out.println(new OrderMaker().prepareOrder(order));
        }

        closeOrder();
    }

    private ArrayList<Validator>  getValidatorList (){
        ArrayList<Validator> validatorList = new ArrayList<>();
        validatorList.add(new OrderInStockValidator());
        return validatorList;
    }

    private Order takeOrder (){
        return new OrderReceiver().assembleOrder();
    }

    private boolean validateOrder(Order order, ArrayList<Validator> validatorList){
        return new OrderValidator(order, validatorList).validateOrder();
    }

    private void closeOrder (){
        if (new OrderReceiver().closeOrder()){
            getAndDeliverOrder();
        }
        else {
            new OrderReceiver().closeCoffeeMachine();
        }
    }

}
