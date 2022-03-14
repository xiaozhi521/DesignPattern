package org.designmode.behavior.templte.order_jdk2;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OrderService extends Observable {

    private static List  userArrayList = new ArrayList();

    public void addOrderListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void creatOrder(){
        userArrayList.add(111);
        System.out.println("开始创建订单");
        this.setChanged();
        this.notifyObservers();
    }
}
