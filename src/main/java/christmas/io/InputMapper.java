package christmas.io;

import christmas.domain.VisitDate;

public class InputMapper {

    public VisitDate toVisitDate(final String visitDate) {
        return new VisitDate(Integer.parseInt(visitDate));
    }
}
