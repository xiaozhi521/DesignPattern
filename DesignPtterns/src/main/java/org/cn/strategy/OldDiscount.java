package org.cn.strategy;

public class OldDiscount implements DiscountStrategy{
    public double getDiscount(double originPrice) {
        System.out.println("使用旧书折扣。。。。");
        return originPrice * 0.7;
    }
}
