package christmas;

import christmas.controller.ChristmasController;
import christmas.factory.ChristmasFactory;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = ChristmasFactory.INSTANCE.christmasController();
        christmasController.run();
    }
}
