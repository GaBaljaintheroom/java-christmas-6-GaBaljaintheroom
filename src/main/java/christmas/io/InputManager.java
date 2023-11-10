package christmas.io;

import christmas.domain.VisitDate;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(InputView inputView, InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public VisitDate inputVisitDate() {
        String visitDate = inputView.inputVisitDate();
        return inputMapper.toVisitDate(visitDate);
    }
}
