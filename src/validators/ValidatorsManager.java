package validators;

import java.util.ArrayList;

public class ValidatorsManager {

    public ArrayList<Validator> getValidatorList() {
        ArrayList<Validator> validatorList = new ArrayList<>();
        validatorList.add(new OrderInStockValidator());
        return validatorList;
    }
}

