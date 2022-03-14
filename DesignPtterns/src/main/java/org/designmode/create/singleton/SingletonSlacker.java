package org.designmode.create.singleton;

/**
 * 懒汉式
 */
public class SingletonSlacker {
    //使用一个类变量缓存曾经创建的实例
    private static SingletonSlacker singleton;
    //将构造器使用 private 修饰，隐藏改构造器
    private SingletonSlacker(){}
    //提供一个静态方法，用于返回Singleton实例
    //该方法可以加入自定义的控制，保证只产生一个Singleton 对象

    public static SingletonSlacker getSingleton(){
        if(singleton == null){
            singleton = new SingletonSlacker();
        }
        return singleton;
    }
}
