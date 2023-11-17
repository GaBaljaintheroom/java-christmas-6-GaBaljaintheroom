package christmas.io;

import christmas.domain.menu.Menus;
import christmas.domain.VisitDate;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(final InputView inputView, final InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public VisitDate inputVisitDate() {
        String visitDate = inputView.inputVisitDate();
        return inputMapper.toVisitDate(visitDate);
    }

    public Menus inputOrderMenus() {
        String order = inputView.inputOrder();
        return inputMapper.toMenus(order);
    }
}
