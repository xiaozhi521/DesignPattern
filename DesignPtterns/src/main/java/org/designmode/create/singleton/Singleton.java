package org.designmode.create.singleton;

import java.util.HashMap;

/**
 * 恶汉式 和 懒汉式 失去了多态性，不允许被继承。
 * 还有一种灵活点的实现，将构造函数设置为受保护的，这样允许被继承产生子类。
 * 这种方式在具体实现上又有所不同，可已将父类中获得对象的静态方法放到子类中在实现；
 *  也可以在父类静态方法中进行条件判断来决定获得哪一个对象；
 *   在 GOF 中认为最好的一种方式是维护一张存有对象和对应名称的注册表（可以使用 HashMap 来实现）。
 *   下面的实现参考  《java与模式》 采用带有注册表的方式
 */
public class Singleton {
    //用来存放对应关系
    private static HashMap hashMap = new HashMap();
    static private Singleton singleton = new Singleton();

    //受保护的构造函数
    protected Singleton(){}
    public static Singleton getSingleton(String name){
        if(name == null){
            name = "Singleton";
        }
        if(hashMap.get("name") == null){
            try {
                hashMap.put(name, Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (Singleton)(hashMap.get(name));
    }
    public void test(){
        System.out.println("getclasssucess");
    }
}
