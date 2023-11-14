package christmas.constants;

public enum PreviewElementForm {
    BENEFIT_PRICE_FORM("-%,d원"),
    ORDER_PRICE_FORM("%,d원"),
    ORDER_MENU_FORM("%s %s개");
    PreviewElementForm(String form) {
        this.form = form;
    }

    public static final String NEXT_LINE = "\n";
    private final String form;

    public String getForm() {
        return form + NEXT_LINE;
    }
}
