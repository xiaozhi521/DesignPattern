package org.designmode.behavior.strategy.test1;



/**
 * 为 XiaoShouSale 接口提供一个 Old 打折的算法
 */
public class PVIPUser implements XiaoShouSale {

    public String getDiscountType() {
        System.out.println("P-VIP用户");
        return "PVIP";
    }

    public String getName(String name) {
        System.out.println("P-VIP用户" + name + "购买了商品");
        return name;
    }
}
