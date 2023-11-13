package christmas.exception;

import christmas.constants.ErrorMessage;

public class DomainNullException extends IllegalStateException {

    public DomainNullException() {
        super(ErrorMessage.DOMAIN_NULL_ERROR.getMessage());
    }
}
