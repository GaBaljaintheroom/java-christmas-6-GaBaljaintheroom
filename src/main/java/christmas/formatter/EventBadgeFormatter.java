package christmas.formatter;

import christmas.constants.PreviewElement;

public final class EventBadgeFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private EventBadgeFormatter() {
    }

    public static String showEventBadge(final String badge) {
        sb.append(PreviewElement.EVENT_BADGE.getElement())
                .append(badge)
                .append("\n");
        return sb.toString();
    }
}
