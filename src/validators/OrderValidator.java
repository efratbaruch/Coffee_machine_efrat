package validators;

import orderComponents.Order;

import java.util.ArrayList;

public class OrderValidator {

    private Order order;
    private ArrayList<Validator> validatorList;

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
