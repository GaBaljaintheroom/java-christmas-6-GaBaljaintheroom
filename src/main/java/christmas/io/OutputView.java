package christmas.io;

import christmas.constants.ProgressMessage;

public class OutputView {
    public void printErrorMessage(final String error) {
        System.out.println(error);
    }

    public void printStartMessage() {
        System.out.println(ProgressMessage.START_MESSAGE);
    }

    public void printVisitDateMessage() {
        System.out.println(ProgressMessage.VISIT_DATE_MESSAGE);
    }
}
