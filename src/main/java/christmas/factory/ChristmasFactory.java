package christmas.factory;

import christmas.controller.ChristmasController;
import christmas.io.InputManager;
import christmas.io.InputMapper;
import christmas.io.InputView;
import christmas.io.OutputView;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;
import christmas.service.EventDetailService;
import christmas.service.OrderService;
import christmas.validator.InputValidator;

public enum ChristmasFactory {
    INSTANCE;

    private final ChristmasController christmasController;

    ChristmasFactory() {
        this.christmasController = new ChristmasController(inputManger(), outputView(), orderService(), eventDetailService());
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

    private OrderService orderService() {
        return new OrderService(orderRepository(), benefitDetailsRepository());
    }

    private EventDetailService eventDetailService() {
        return new EventDetailService(orderRepository(), benefitDetailsRepository());
    }

    private OrderRepository orderRepository() {
        return OrderRepository.INSTANCE;
    }

    private EventDetailsRepository benefitDetailsRepository() {
        return EventDetailsRepository.INSTANCE;
    }
}
