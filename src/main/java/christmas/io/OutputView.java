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

    public void printOrderMenuMessage() {
        System.out.println(ProgressMessage.ORDER_MENU_MESSAGE);
    }

    public void printPreviewEventMessage(final Integer visitDate) {
        System.out.printf((ProgressMessage.PREVIEW_EVENT_MESSAGE) + "%n", visitDate);
    }

    public void printPreviewEventCase(final String eventCase) {
        System.out.println(eventCase);
    }
}
