package christmas.formatter;

public final class EventBadgeFormatter {

    public static final String EVENT_BADGE = "<12월 이벤트 배지>\n";
    private static final StringBuilder sb = new StringBuilder();

    private EventBadgeFormatter() {
    }

    public static String showEventBadge(String badge) {
        sb.append(EVENT_BADGE)
                .append(badge)
                .append("\n");
        return sb.toString();
    }
}
