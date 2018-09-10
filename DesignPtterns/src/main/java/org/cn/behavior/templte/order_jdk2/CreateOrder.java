package org.cn.behavior.templte.order_jdk2;


import java.util.Observable;
import java.util.Observer;

public class CreateOrder implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("创建【" + arg +"】订单，订单编号：LH" + System.currentTimeMillis());
    }
}
