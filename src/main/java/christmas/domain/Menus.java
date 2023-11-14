package christmas.domain;

import christmas.constants.ChristmasRule;
import christmas.exception.InvalidOrderException;
import christmas.exception.OverOrderCountException;
import java.util.List;

public class Menus {

    private final List<Menu> values;

    private Menus(final List<Menu> values) {
        validateDuplicateMenu(values);
        validateMenuCount(values);
        this.values = values;
    }

    public static Menus from(final List<Menu> values) {
        return new Menus(values);
    }

    private void validateDuplicateMenu(final List<Menu> values) {
        if (isDuplicatedMenus(values)) {
            throw new InvalidOrderException();
        }
    }

    private boolean isDuplicatedMenus(final List<Menu> values) {
        return values.size() != getMenuCount(values);
    }

    private long getMenuCount(final List<Menu> values) {
        return values.stream()
                .map(Menu::getMenuName)
                .distinct()
                .count();
    }

    private void validateMenuCount(final List<Menu> values) {
        if (getOrderTotalCount(values) > ChristmasRule.MAX_ORDER_COUNT.getValue()) {
            throw new OverOrderCountException();
        }
    }

    private int getOrderTotalCount(final List<Menu> values) {
        return values.stream()
                .mapToInt(Menu::getMenuAmountValue)
                .sum();
    }


    public boolean isContainMenuName(final Name name) {
        return values.stream()
                .map(Menu::getMenuName)
                .anyMatch(menuName -> menuName.equals(name));
    }

    public Integer getPriceValueByMenuName(final Menu orderMenu) {
        Name menuName = orderMenu.getMenuName();
        return values.stream()
                .filter(m -> m.isEqualName(menuName))
                .findFirst().stream()
                .mapToInt(m -> m.getPriceValue() * orderMenu.getMenuAmountValue())
                .sum();
    }

    public Long matchingOrderMenuCount(final Menus orderMenus) {
        List<Menu> menusValues = orderMenus.getValues();

        return values.stream()
                .flatMap(menu -> menusValues.stream()
                        .filter(orderMenu -> menu.getMenuName().equals(orderMenu.getMenuName()))
                        .map(Menu::getMenuAmountValue))
                .mapToLong(Integer::longValue)
                .sum();
    }

    public List<Menu> getValues() {
        return List.copyOf(values);
    }
}
