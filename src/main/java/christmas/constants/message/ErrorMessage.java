package christmas.constants.message;

public enum ErrorMessage {

    ERROR_TAG("[ERROR] "),
    INVALID_DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    DOMAIN_NULL_ERROR("객체가 초기화되어 있지 않습니다."),
    INVALID_ORDER_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE_ORDER_ERROR("음료만 주문 시, 주문할 수 없습니다."),
    OVER_ORDER_COUNT_ERROR("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    NOT_FOUND_CATEGORY_MENU_BY_DAY_ERROR("해당 하는 요일의 할인 메뉴를 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG.message + message + "\n";
    }

    @Override
    public String toString() {
        return message;
    }
}
