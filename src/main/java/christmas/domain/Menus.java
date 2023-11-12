package christmas.domain;

import christmas.exception.InvalidOrderException;
import christmas.exception.OverOrderCountException;

import java.util.List;

public class Menus {

    private static final int MAX_ORDER_COUNT = 20;
    private final List<Menu> values;

    private Menus(final List<Menu> values) {
        validateDuplicateMenu(values);
        validateMenuCount(values);
        this.values = values;
    }

    public static Menus from(final List<Menu> values) {
        return new Menus(values);
    }

    private void validateDuplicateMenu(List<Menu> values) {
        if (isDuplicatedMenus(values)) {
            throw new InvalidOrderException();
        }
    }

    private boolean isDuplicatedMenus(List<Menu> values) {
        return values.size() != getMenuCount(values);
    }

    private long getMenuCount(List<Menu> values) {
        return values.stream()
                .map(Menu::getMenuName)
                .distinct()
                .count();
    }

    private void validateMenuCount(List<Menu> values) {
        if (getOrderTotalCount(values) > MAX_ORDER_COUNT) {
            throw new OverOrderCountException();
        }
    }

    private int getOrderTotalCount(List<Menu> values) {
        return values.stream()
                .mapToInt(Menu::getMenuAmountValue)
                .sum();
    }


    public boolean isContainMenuName(final Name name) {
        return values.stream()
                .map(Menu::getMenuName)
                .anyMatch(menuName -> menuName.equals(name));
    }

    public Integer getPriceValueByMenuName(Menu orderMenu) {
        Name menuName = orderMenu.getMenuName();
        return values.stream()
                .filter(m -> m.isEqualName(menuName))
                .findFirst().stream()
                .mapToInt(m -> m.getPriceValue() * orderMenu.getMenuAmountValue())
                .sum();
    }

    public List<Menu> getValues() {
        return List.copyOf(values);
    }

    public Long matchingOrderMenuCount(Menus orderMenus) {
        return orderMenus.getValues().stream()
                .map(Menu::getMenuName)
                .filter(this::isContainMenuName)
                .count();
    }
}
