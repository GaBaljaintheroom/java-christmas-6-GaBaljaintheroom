package christmas.factory;

import christmas.controller.ChristmasController;
import christmas.io.InputManager;
import christmas.io.InputMapper;
import christmas.io.InputView;
import christmas.io.OutputView;

public enum ChristmasFactory {
    INSTANCE;

    private final ChristmasController christmasController;

    ChristmasFactory() {
        this.christmasController = new ChristmasController(inputManger(), outputView());
    }

    public ChristmasController christmasController() {
        return christmasController;
    }

    private InputManager inputManger() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputView inputView() {
        return new InputView();
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
