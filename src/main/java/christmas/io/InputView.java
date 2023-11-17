package christmas.io;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputVisitDate() {
        String visitDate = Console.readLine();
        inputValidator.validateNumericDate(visitDate);
        return visitDate;
    }

    public String inputOrder() {
        String order = Console.readLine();
        inputValidator.validateOrderPattern(order);
        return order;
    }
}
