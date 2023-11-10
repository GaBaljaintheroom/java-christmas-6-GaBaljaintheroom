package christmas.constants;

public enum ErrorMessage {

    ERROR_TAG("[ERROR] "),
    INVALID_DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    DOMAIN_NULL_ERROR("객체가 초기화되어 있지 않습니다.");

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
