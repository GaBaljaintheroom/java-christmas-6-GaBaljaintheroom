package christmas.exception;

import christmas.constants.ErrorMessage;

public class InvalidOrderException extends IllegalArgumentException {

    public InvalidOrderException() {
        super(ErrorMessage.INVALID_ORDER_ERROR.getMessage());
    }
}
