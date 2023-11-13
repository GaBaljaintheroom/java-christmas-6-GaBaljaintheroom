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

    public void printPreviewEventMessage(Integer visitDate) {
        System.out.printf((ProgressMessage.PREVIEW_EVENT_MESSAGE) + "%n", visitDate);
    }

    public void printPreviewEventCase(final String eventCase) {
        System.out.println(eventCase);
    }

    public void printToTalOrderPriceMessage(String checkTotalOrderPrice) {
        System.out.println(checkTotalOrderPrice);
    }

    public void printGiveawayMenuMessage(String checkGiveawayMenu) {
        System.out.println(checkGiveawayMenu);
    }

    public void printBenefitDetailsMessage(String showBenefitDetails) {
        System.out.println(showBenefitDetails);
    }

    public void printTotalBenefitPrice(String showTotalBenefitPrice) {
        System.out.println(showTotalBenefitPrice);
    }

    public void printExpectOrderPrice(String showExpectOrderPrice) {
        System.out.println(showExpectOrderPrice);
    }

    public void printEventBadge(String showEventBadge) {
        System.out.println(showEventBadge);
    }
}
