package christmas.domain.preview;

public class TotalDiscountPrice {

    private final Integer discountPrice;

    private TotalDiscountPrice(final Integer price) {
        this.discountPrice = price;
    }

    public static TotalDiscountPrice from(final ChristmasDDayDiscount christMasDDayDiscount,
                                          final DaysDiscount daysDiscount
            , final SpecialEventDiscount specialEventDiscount) {
        int totalBenefit = christMasDDayDiscount.getDiscount() + daysDiscount.getDiscount()
                + specialEventDiscount.getDiscount();
        return new TotalDiscountPrice(totalBenefit);
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }
}
