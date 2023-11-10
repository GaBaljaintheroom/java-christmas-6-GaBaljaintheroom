package christmas.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String inputVisitDate() {
        String visitDate = Console.readLine();
        inputValidator.validateInvalidDate(visitDate);
        return visitDate;
    }
}
