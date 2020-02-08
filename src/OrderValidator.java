import java.util.ArrayList;

public class OrderValidator {

    //todo: who holds the validator list?
    private Order order;
    private ArrayList<Validator> validatorList;

    //todo: check constructors
    OrderValidator(Order order, ArrayList<Validator> validatorList) {
        this.order = order;
        this.validatorList = validatorList;
    }

    boolean validateOrder() {
        for (Validator validator : validatorList) {
            boolean isValid = validator.validate(order);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }


}
