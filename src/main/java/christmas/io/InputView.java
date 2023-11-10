package christmas.io;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String inputVisitDate() {
        String visitDate = Console.readLine();
        inputValidator.validateNumericDate(visitDate);
        return visitDate;
    }
}
