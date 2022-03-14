package org.designmode.behavior.observer.order_jdk_error;


public class OrderService{

    public void creatOrder(String productName,String packName,String fastMailName){
        new OrderObserver().createOrder(productName);
        new PackObserver().createPack(packName);
        new FastMailObserver().setFastMail(fastMailName);
    }
}
