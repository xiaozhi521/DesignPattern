package org.designmode.create.singleton;

/**
 *  由于在 java 中子类的构造函数的范围不能比父类小，
 *  所以可能存在不守规则的客户程序使用其构造函数来产生实例，造成单例模式失效
 */
public class SingletonChild extends Singleton {
    public SingletonChild(){}

    public static SingletonChild singletonChild(){
        return (SingletonChild) getSingleton("SingletonChild");
    }
    public void test(){
        System.out.println("get class success 111!");
    }
}
