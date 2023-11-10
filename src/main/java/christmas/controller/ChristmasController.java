package christmas.controller;

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
    }

    private void createVisitDate() {
        outputView.printVisitDateMessage();
        VisitDate visitDate = read(inputManager::inputVisitDate);
        christmasService.saveVisitDate(visitDate);
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
