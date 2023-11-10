package christmas.controller;

import christmas.domain.VisitDate;
import christmas.io.InputManager;
import christmas.io.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final InputManager inputManager;
    private final OutputView outputView;

    public ChristmasController(InputManager inputManager, OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        outputView.printVisitDateMessage();
        VisitDate visitDate = read(inputManager::inputVisitDate);
    }

    private <T> T read(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
