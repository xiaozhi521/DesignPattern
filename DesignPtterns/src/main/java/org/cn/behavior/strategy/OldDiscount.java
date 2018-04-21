package org.cn.behavior.strategy;

/**
 * 为 DiscountStrategy 接口提供一个 Old 打折的算法
 */
public class OldDiscount implements DiscountStrategy{

    //重写 getDiscount() 方法，提供 old 打折算法
    public double getDiscount(double originPrice) {
        System.out.println("使用旧书折扣。。。。");
        return originPrice * 0.7;
    }
}
