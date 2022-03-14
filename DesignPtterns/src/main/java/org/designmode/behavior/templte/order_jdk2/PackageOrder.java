package org.designmode.behavior.templte.order_jdk2;


import java.util.Observable;
import java.util.Observer;

public class PackageOrder implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("开始【私密】包装");
    }
}
