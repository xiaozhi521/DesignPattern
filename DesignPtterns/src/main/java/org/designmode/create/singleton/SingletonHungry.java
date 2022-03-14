package org.designmode.create.singleton;

/**
 * 恶汉式
 */
public class SingletonHungry {
    //在自己内部定义自己一个实例
    //注意这是 private 只供内部调用
    private static SingletonHungry singletonHungry = new SingletonHungry();
    //如上所述，将构造器函数设置为私有
    private SingletonHungry(){}
    //静态工厂方法，提供了一个供外部访问得到对象的静态方法
    public static SingletonHungry getSingletonHungry(){
        return singletonHungry;
    }
}
