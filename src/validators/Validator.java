package validators;

import orderComponents.Order;

public interface Validator {

    boolean validate(Order order);

}
