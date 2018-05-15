package org.cn.behavior.observer;

public class Product extends Observable {
    //定义两个成员变量
    private String name;
    private double price;
    // 无参数的构造器
    public Product(){}
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return  name;
    }
    //当程序调用name 的 setter 方法来修改 product 的 name 成员变量时
    //程序自然触发对象上注册的所有观察者
    public void setName(String name){
        this.name = name;
        notifyObserver(name);
    }

    //当程序调用price的setter方法来修改 product 的 price 成员变量时
    //程序自然触发对象上注册的所有观察者
    public void setPrice(double price){
        this.price = price;
        notifyObserver(price);
    }

}
