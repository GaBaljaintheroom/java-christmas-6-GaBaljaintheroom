package christmas.formatter;

import christmas.constants.element.PreviewElement;
import christmas.constants.element.PreviewElementForm;

public final class EventBadgeFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private EventBadgeFormatter() {
    }

    public static String showEventBadge(final String badge) {
        sb.append(PreviewElement.EVENT_BADGE.getElement())
                .append(badge)
                .append(PreviewElementForm.NEXT_LINE);
        return sb.toString();
    }
}
