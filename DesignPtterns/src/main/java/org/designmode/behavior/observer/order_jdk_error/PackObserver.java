package org.designmode.behavior.observer.order_jdk_error;


public class PackObserver{

    public String createPack(String name){
        System.out.println("开始【"+ name + "】包装");
        return "开始私密包装";
    }
}
