package christmas.exception;

import christmas.constants.ErrorMessage;

public class NotFoundCategoryMenuByDay extends IllegalStateException {

    public NotFoundCategoryMenuByDay() {
        super(ErrorMessage.NOT_FOUND_CATEGORY_MENU_BY_DAY_ERROR.getMessage());
    }
}
