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
        checkTotalOrderPrice();
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
        String checkOrderMenus = christmasService.checkOrderMenus(orderMenus);

        outputView.printPreviewEventMessage(christmasService.getVisitDate());
        outputView.printPreviewEventCase(checkOrderMenus);
    }

    private void checkTotalOrderPrice() {
        String totalOrderPrice = christmasService.checkTotalOrderPrice();
        outputView.printPreviewEventCase(totalOrderPrice);
    }

    private void previewEventBenefit() {
        christmasService.saveGiveawayMenu();
        outputView.printGiveawayMenuMessage(christmasService.checkGiveWayMenu());

        // 혜택 저장
        christmasService.saveChristmasDDayDiscount();
        christmasService.saveDaysDiscount();
        christmasService.saveSpecialEventDiscount();

        // 혜택 내역 출력
        outputView.printBenefitDetailsMessage(christmasService.showBenefitDetails());

        // 총 혜택 금액 출력
        outputView.printTotalBenefitPrice(christmasService.showTotalBenefitPrice());

        // 할인 후 예상 결제 금액 저장
        christmasService.saveExpectOrderPrice();

        // 할인 후 예상 결제 출력
        outputView.printExpectOrderPrice(christmasService.showExpectOrderPrice());

        // 12월 이벤트 배지 출력
        outputView.printEventBadge(christmasService.showEventBadge());
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
