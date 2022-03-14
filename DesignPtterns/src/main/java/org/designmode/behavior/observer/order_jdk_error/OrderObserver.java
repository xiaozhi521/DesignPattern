package org.designmode.behavior.observer.order_jdk_error;


public class OrderObserver {

    public String createOrder(String name){
        System.out.println("创建【" + name +"】订单，订单编号：LH" + System.currentTimeMillis());
        return "LH" + System.currentTimeMillis();
    }
}
