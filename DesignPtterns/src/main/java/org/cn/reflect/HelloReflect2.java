package org.cn.reflect;

/**
 *  构建方法含有参数的类
 */
public class HelloReflect2 {
    private String name;

    public HelloReflect2(){}

    public HelloReflect2(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("HelloReflect2 " + name);
    }
}
