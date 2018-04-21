package org.cn.strategy;

public class DiscountContext {
    //组合一个DiscountStrategy 对象
    private DiscountStrategy strategy;
    // 构造器
    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double getDiscountPrice(double price){
        if(strategy == null){
            strategy = new OldDiscount();
        }
        return this.strategy.getDiscount(price);
    }
    //提供切换算法的方法
    public void changeDiscount(DiscountStrategy strategy){
        this.strategy = strategy;
    }
}
