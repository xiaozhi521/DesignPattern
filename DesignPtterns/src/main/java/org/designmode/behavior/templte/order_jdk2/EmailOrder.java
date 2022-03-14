package org.designmode.behavior.templte.order_jdk2;


import java.util.Observable;
import java.util.Observer;

public class EmailOrder implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("使用【顺丰】发送");
    }
}
