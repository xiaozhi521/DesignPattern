package org.designmode.behavior.observer.product_jdk;


import java.util.Observable;
import java.util.Observer;

public class TaoBaoObserver implements Observer {
    public void update(Observable o, Object arg) {
        String newProduct = (String)arg;
        System.out.println("发送新产品【" + newProduct +"】同步到淘宝商城");
    }
}
