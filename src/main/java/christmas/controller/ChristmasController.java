package christmas.controller;

import christmas.domain.Menus;
import christmas.domain.VisitDate;
import christmas.io.InputManager;
import christmas.io.OutputView;
import christmas.service.ChristmasService;
import java.util.function.Supplier;

public class ChristmasController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final ChristmasService christmasService;


    public ChristmasController(final InputManager inputManager, final OutputView outputView,
                               final ChristmasService christmasService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        outputView.printStartMessage();

        createVisitDate();
        orderMenus();
        checkTotalOrderPrice();
        checkGiveawayEvent();
        checkBenefitDetails();
        checkPaymentAndBadge();
    }

    private void createVisitDate() {
        outputView.printVisitDateMessage();
        VisitDate visitDate = read(inputManager::inputVisitDate);
        christmasService.saveVisitDate(visitDate);
    }

    private void orderMenus() {
        outputView.printOrderMenuMessage();
        Menus orderMenus = read(inputManager::inputOrderMenus);
        String checkOrderMenus = christmasService.checkOrderMenus(orderMenus);

        outputView.printPreviewEventMessage(christmasService.getVisitDate());
        outputView.printPreviewEventCase(checkOrderMenus);
    }

    private void checkTotalOrderPrice() {
        String totalOrderPrice = christmasService.checkTotalOrderPrice();
        outputView.printPreviewEventCase(totalOrderPrice);
    }

    private void checkGiveawayEvent() {
        String giveawayMenuEvent = christmasService.showGiveawayMenuEvent();
        outputView.printPreviewEventCase(giveawayMenuEvent);
    }

    private void checkBenefitDetails() {
        christmasService.saveChristmasDDayDiscount();
        christmasService.saveDaysDiscount();
        christmasService.saveSpecialEventDiscount();

        outputView.printBenefitDetailsMessage(christmasService.showBenefitDetails());
    }

    private void checkPaymentAndBadge() {
        outputView.printPreviewEventCase(christmasService.showTotalBenefitPrice());
        outputView.printPreviewEventCase(christmasService.checkExpectPaymentPrice());
        outputView.printPreviewEventCase(christmasService.showEventBadge());
    }

    private <T> T read(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
