package christmas.validator;

import christmas.constants.InputPattern;
import christmas.exception.InvalidDateException;

public class InputValidator {

    public void validateNumericDate(final String visitDate) {
        if (InputPattern.isNotNumeric(visitDate)) {
            throw new InvalidDateException();
        }
    }
}
