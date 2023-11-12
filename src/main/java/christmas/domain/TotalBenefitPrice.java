package christmas.domain;

public class TotalBenefitPrice {

    private final Integer price;

    private TotalBenefitPrice(Integer price) {
        this.price = price;
    }

    public static TotalBenefitPrice from(ChristmasDDayDiscount christMasDDayDiscount, DaysDiscount daysDiscount
            , SpecialEventDiscount specialEventDiscount, GiveawayMenu giveawayMenu) {
        int totalBenefit = christMasDDayDiscount.getDiscount() + daysDiscount.getDiscount()
                + specialEventDiscount.getDiscount() + giveawayMenu.getPrice();
        return new TotalBenefitPrice(totalBenefit);
    }
}
