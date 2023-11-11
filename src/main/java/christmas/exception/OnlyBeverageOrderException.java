package christmas.exception;

import christmas.constants.ErrorMessage;

public class OnlyBeverageOrderException extends IllegalArgumentException {
    public OnlyBeverageOrderException() {
        super(ErrorMessage.ONLY_BEVERAGE_ORDER_ERROR.getMessage());
    }
}
