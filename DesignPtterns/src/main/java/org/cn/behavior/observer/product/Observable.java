package org.cn.behavior.observer.product;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    //用一个 List 来保存该对象上所有绑定的事件监听器
    List<Observer> observableList = new ArrayList<Observer>();
    //定义一个方法，用于从该主题上注册观察者
    public void registObser0ver(Observer Observer){
        observableList.add(Observer);
    }

    //定义一个方法，用于从该主题中删除观察者
    public void removeObserver(Observer Observer){
        observableList.remove(Observer);
    }

    //通知该主题上注册的所有观察者
    public void notifyObserver(Object object){
        for(Observer o : observableList){
            o.update(o,object);
        }
    }
}
