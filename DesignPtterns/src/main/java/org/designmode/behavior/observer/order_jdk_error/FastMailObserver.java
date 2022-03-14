package org.designmode.behavior.observer.order_jdk_error;

import java.util.Observable;

public class FastMailObserver extends Observable {

    public String setFastMail(String name){
        System.out.println("使用【"+ name +"】发送");
        this.setChanged();
        this.notifyObservers();
        return "使用【"+ name +"】发送";
    }
}
