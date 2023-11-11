package christmas.domain;

public class Amount {

    private final Integer menuAmount;

    private Amount(Integer menuAmount) {
        this.menuAmount = menuAmount;
    }

    public static Amount from(Integer menuAmount) {
        return new Amount(menuAmount);
    }

    public Integer getMenuAmount() {
        return menuAmount;
    }
}
