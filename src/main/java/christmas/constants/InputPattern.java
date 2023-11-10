package christmas.constants;

import java.util.regex.Pattern;

public enum InputPattern {
    NUMERIC_PATTERN(Pattern.compile("^\\d*$")),
    ORDER_PATTERN(Pattern.compile("([가-힣a-zA-Z]+)-([1-9]+)"));

    private final Pattern pattern;

    InputPattern(final Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotNumeric(final String visitDate) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(visitDate).matches();
    }

    public static boolean isNotOrderPattern(final String order) {
        Pattern pattern = ORDER_PATTERN.pattern;
        return !pattern.matcher(order).matches();
    }
}

