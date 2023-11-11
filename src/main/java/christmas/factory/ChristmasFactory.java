package christmas.factory;

import christmas.controller.ChristmasController;
import christmas.io.InputManager;
import christmas.io.InputMapper;
import christmas.io.InputView;
import christmas.io.OutputView;
import christmas.repository.ChristmasRepository;
import christmas.service.ChristmasService;
import christmas.validator.InputValidator;

public enum ChristmasFactory {
    INSTANCE;

    private final ChristmasController christmasController;

    ChristmasFactory() {
        this.christmasController = new ChristmasController(inputManger(), outputView(), christmasService());
    }

    public ChristmasController christmasController() {
        return christmasController;
    }

    private InputManager inputManger() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private ChristmasService christmasService() {
        return new ChristmasService(christmasRepository());
    }

    private ChristmasRepository christmasRepository() {
        return new ChristmasRepository();
    }
}
