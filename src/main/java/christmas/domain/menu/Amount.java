package christmas.domain.menu;

public class Amount {

    private final Integer menuAmount;

    private Amount(final Integer menuAmount) {
        this.menuAmount = menuAmount;
    }

    public static Amount from(final Integer menuAmount) {
        return new Amount(menuAmount);
    }

    public Integer getMenuAmount() {
        return menuAmount;
    }
}
