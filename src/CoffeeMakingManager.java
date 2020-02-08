import java.util.ArrayList;
import java.util.HashMap;

public class CoffeeMakingManager {

    void getAndDeliverOrder(){

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
