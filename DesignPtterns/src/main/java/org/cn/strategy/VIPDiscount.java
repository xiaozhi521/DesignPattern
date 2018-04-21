package org.cn.strategy;

public class VIPDiscount implements DiscountStrategy{

    public double getDiscount(double originPrice) {
        System.out.println("使用VIP折扣。。。。。");
        return originPrice * 0.5;
    }
}
