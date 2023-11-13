package christmas.validator;

import christmas.constants.InputPattern;
import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;

public class InputValidator {

    private static final String DIVISION = ",";

    public void validateNumericDate(final String visitDate) {
        if (InputPattern.isNotNumeric(visitDate)) {
            throw new InvalidDateException();
        }
    }

    public void validateOrderPattern(final String order) {
        Arrays.stream(order.split(DIVISION))
                .parallel()
                .filter(InputPattern::isNotOrderPattern)
                .findAny()
                .ifPresent(o -> {
                    throw new InvalidOrderException();
                });
    }

}
