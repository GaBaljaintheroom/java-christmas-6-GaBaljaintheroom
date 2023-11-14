package christmas.exception;

import christmas.constants.message.ErrorMessage;

public class InvalidOrderException extends IllegalArgumentException {

    public InvalidOrderException() {
        super(ErrorMessage.INVALID_ORDER_ERROR.getMessage());
    }
}
