package christmas.constants;

public enum PreviewElement {
    BENEFIT_DETAILS("<혜택 내역>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    EXPECT_ORDER_PRICE("<할인 후 예상 결제 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    TOTAL_ORDER_PRICE("<할인 전 총주문 금액>"),
    NONE("없음");

    private static final String NEXT_LINE = "\n";
    PreviewElement(String element) {
        this.element = element + NEXT_LINE;
    }

    private final String element;

    public String getElement() {
        return element;
    }
}
