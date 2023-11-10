package christmas.io;

import christmas.constants.InputPattern;
import christmas.exception.InvalidDateException;

public class InputValidator {

    public void validateInvalidDate(String visitDate) {
        if (InputPattern.isNotNumeric(visitDate)) {
            throw new InvalidDateException();
        }
    }
}
