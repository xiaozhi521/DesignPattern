package org.cn.behavior.templte.order_jdk1;


public class OrderService{

    public void creatOrder(String productName,String packName,String fastMailName){
        new OrderObserver().createOrder(productName);
        new PackObserver().createPack(packName);
        new FastMailObserver().setFastMail(fastMailName);
    }
}
