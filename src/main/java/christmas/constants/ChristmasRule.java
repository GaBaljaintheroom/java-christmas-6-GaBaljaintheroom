package christmas.constants;

public enum ChristmasRule {
    NO_DISCOUNT(0),
    MAX_ORDER_COUNT(20),
    EVENT_YEAR(2023),
    EVENT_MONTH(12);


    ChristmasRule(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public Integer getValue() {
        return value;
    }
}
