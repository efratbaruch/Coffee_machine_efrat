package validators;

import orderComponents.Order;
import validators.Validator;

import java.util.ArrayList;

public class OrderValidator {

    //todo: change classes names
    //todo: arrange packages
    //todo: who holds the validator list?
    private Order order;
    private ArrayList<Validator> validatorList;

    //todo: check constructors
    public OrderValidator(Order order, ArrayList<Validator> validatorList) {
        this.order = order;
        this.validatorList = validatorList;
    }

    public boolean validateOrder() {
        for (Validator validator : validatorList) {
            boolean isValid = validator.validate(order);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }


}
