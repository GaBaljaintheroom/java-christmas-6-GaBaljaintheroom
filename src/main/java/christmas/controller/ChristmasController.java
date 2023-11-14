package christmas.controller;

import christmas.domain.menu.Menus;
import christmas.domain.VisitDate;
import christmas.io.InputManager;
import christmas.io.OutputView;
import christmas.service.EventDetailService;
import christmas.service.OrderService;
import java.util.function.Supplier;

public class ChristmasController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final OrderService orderService;
    private final EventDetailService eventDetailService;


    public ChristmasController(final InputManager inputManager, final OutputView outputView,
                               final OrderService orderService, final EventDetailService eventDetailService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.orderService = orderService;
        this.eventDetailService = eventDetailService;
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
        orderService.saveVisitDate(visitDate);
    }

    private void orderMenus() {
        outputView.printOrderMenuMessage();
        Menus orderMenus = read(inputManager::inputOrderMenus);
        String checkOrderMenus = orderService.checkOrderMenus(orderMenus);

        outputView.printPreviewEventMessage(orderService.getVisitDate());
        outputView.printPreviewEventCase(checkOrderMenus);
    }

    private void checkTotalOrderPrice() {
        String totalOrderPrice = orderService.checkTotalOrderPrice();
        outputView.printPreviewEventCase(totalOrderPrice);
    }

    private void checkGiveawayEvent() {
        String giveawayMenuEvent = eventDetailService.showGiveawayMenuEvent();
        outputView.printPreviewEventCase(giveawayMenuEvent);
    }

    private void checkBenefitDetails() {
        eventDetailService.saveChristmasDDayDiscount();
        eventDetailService.saveDaysDiscount();
        eventDetailService.saveSpecialEventDiscount();

        outputView.printPreviewEventCase(eventDetailService.showBenefitDetails());
    }

    private void checkPaymentAndBadge() {
        outputView.printPreviewEventCase(eventDetailService.showTotalBenefitPrice());
        outputView.printPreviewEventCase(orderService.checkExpectPaymentPrice());
        outputView.printPreviewEventCase(eventDetailService.showEventBadge());
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
