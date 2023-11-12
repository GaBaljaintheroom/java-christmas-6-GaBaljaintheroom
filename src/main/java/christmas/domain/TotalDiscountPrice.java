package christmas.domain;

public class TotalDiscountPrice {

    private final Integer price;

    private TotalDiscountPrice(Integer price) {
        this.price = price;
    }

    public static TotalDiscountPrice from(ChristmasDDayDiscount christMasDDayDiscount, DaysDiscount daysDiscount
            , SpecialEventDiscount specialEventDiscount) {
        int totalBenefit = christMasDDayDiscount.getDiscount() + daysDiscount.getDiscount()
                + specialEventDiscount.getDiscount();
        return new TotalDiscountPrice(totalBenefit);
    }

    public Integer getPrice() {
        return price;
    }
}
