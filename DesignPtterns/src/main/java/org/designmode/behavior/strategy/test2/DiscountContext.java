package org.designmode.behavior.strategy.test2;

public class DiscountContext {
    //组合一个DiscountStrategy 对象
    private DiscountStrategy strategy;
    // 构造器，传入一个 DiscountStrategy 对象
    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    //根据实际所用的 DiscountStrategy 对象得到折扣价
    public double getDiscountPrice(double price){
        //如果 strategy == null 系统自动选择 OldDiscount 类
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
