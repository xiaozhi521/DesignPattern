package org.designmode.behavior.strategy.test2;

public class StrategyTest {
    public static void main(String[] args) {
       DiscountContext discountContext = new DiscountContext(null);

       System.out.println("70元的书默认打折价格是：" + discountContext.getDiscountPrice(70));
       discountContext.changeDiscount(new VIPDiscount());

       double price = 80;
        System.out.println("80元的书默认打折价格是：" + discountContext.getDiscountPrice(price));
    }
}
