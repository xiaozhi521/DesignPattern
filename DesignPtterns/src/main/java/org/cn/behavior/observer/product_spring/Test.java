package org.cn.behavior.observer.product_spring;

public class Test {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.saveOrder("veeee");
    }
}
