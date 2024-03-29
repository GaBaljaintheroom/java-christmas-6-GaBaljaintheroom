package christmas.exception;

import christmas.constants.message.ErrorMessage;

public class OverOrderCountException extends IllegalArgumentException {

    public OverOrderCountException() {
        super(ErrorMessage.OVER_ORDER_COUNT_ERROR.getMessage());
    }
}
