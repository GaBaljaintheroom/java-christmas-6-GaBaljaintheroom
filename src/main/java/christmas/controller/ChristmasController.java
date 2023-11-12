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


    public ChristmasController(final InputManager inputManager, final OutputView outputView, final ChristmasService christmasService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        outputView.printStartMessage();

        createVisitDate();
        orderMenus();
        previewEventBenefit();
    }

    private void createVisitDate() {
        outputView.printVisitDateMessage();
        VisitDate visitDate = read(inputManager::inputVisitDate);
        christmasService.saveVisitDate(visitDate);
    }

    private void orderMenus() {
        outputView.printOrderMenuMessage();
        Menus orderMenus = read(inputManager::inputOrderMenus);
        christmasService.saveOrderMenus(orderMenus);
    }

    private void previewEventBenefit() {
        outputView.printPreviewEventMessage(christmasService.getVisitDate());

        outputView.printCheckOrderMenuMessage(christmasService.checkOrderMenu());

        christmasService.saveOrderPrice();
        outputView.printToTalOrderPriceMessage(christmasService.checkTotalOrderPrice());

        christmasService.saveGiveawayMenu();
        outputView.printGiveawayMenuMessage(christmasService.checkGiveWayMenu());

        // 할인 저장
        christmasService.saveChristmasDDayDiscount();
        christmasService.saveDaysDiscount();
        christmasService.saveSpecialEventDiscount();

        // 할인 내역 출력
        outputView.printBenefitDetailsMessage(christmasService.showBenefitDetails());
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
