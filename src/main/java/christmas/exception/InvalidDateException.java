package christmas.exception;

import christmas.constants.message.ErrorMessage;

public class InvalidDateException extends IllegalArgumentException {

    public InvalidDateException() {
        super(ErrorMessage.INVALID_DATE_ERROR.getMessage());
    }
}
