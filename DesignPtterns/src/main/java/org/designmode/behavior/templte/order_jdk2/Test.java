package org.designmode.behavior.templte.order_jdk2;


public class Test {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.addOrderListObserver(new EmailOrder());
        orderService.addOrderListObserver(new PackageOrder());
        orderService.addOrderListObserver(new CreateOrder());
        orderService.creatOrder();
    }
}
