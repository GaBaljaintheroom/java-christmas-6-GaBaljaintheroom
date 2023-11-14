package christmas.domain.menu;

public class Menu {

    private static final Integer INIT_VALUE = 0;
    private final Name menuName;
    private final Price menuPrice;
    private final Amount menuAmount;

    private Menu(final Name name, final Price price) {
        this.menuName = name;
        this.menuPrice = price;
        this.menuAmount = Amount.from(INIT_VALUE);
    }

    private Menu(final Name name, final Amount amount) {
        this.menuName = name;
        this.menuAmount = amount;
        this.menuPrice = Price.from(INIT_VALUE);
    }

    public static Menu of(final Name name, final Price price) {
        return new Menu(name, price);
    }

    public static Menu of(final Name name, final Amount amount) {
        return new Menu(name, amount);
    }

    public boolean isEqualName(final Name name) {
        return menuName.equals(name);
    }

    public Name getMenuName() {
        return menuName;
    }

    public String getMenuNameValue() {
        return menuName.getMenuName();
    }

    public Integer getMenuPriceValue() {
        return menuPrice.getMenuPrice();
    }

    public Integer getMenuAmountValue() {
        return menuAmount.getMenuAmount();
    }
}
