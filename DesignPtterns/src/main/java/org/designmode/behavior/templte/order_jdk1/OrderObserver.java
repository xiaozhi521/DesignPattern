package org.designmode.behavior.templte.order_jdk1;


public class OrderObserver {

    public String createOrder(String name){
        System.out.println("创建【" + name +"】订单，订单编号：LH" + System.currentTimeMillis());
        return "LH" + System.currentTimeMillis();
    }
}
