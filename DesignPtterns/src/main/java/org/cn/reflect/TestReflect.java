package org.cn.reflect;

import org.junit.Test;

public class TestReflect {
    public static void main(String[] args) {
        HelloReflectInstance.getInstance();
    }

    /**
     * 反射生成对象和反射调度方法
     */
    @Test
    public void getReflectMethod2(){
        HelloReflectInstance.getReflect();
    }
    @Test
    public void getReflectMethod(){
        HelloReflectInstance.reflectMethod();
    }
    @Test
    public void helloReflect2Test(){
        HelloReflect2 helloReflect2 = HelloReflect2Instance.getInstance();
        helloReflect2.sayHello();
    }
    @Test
    public void helloReflect2Test2(){
        HelloReflect2 helloReflect2 = HelloReflect2Instance.getInstance("org.cn.reflect.HelloReflect2");
        helloReflect2.sayHello();
    }
    @Test
    public void helloReflect2Test3(){
        HelloReflect2 helloReflect2 = HelloReflect2Instance.getInstance("org.cn.reflect.HelloReflect2",String.class,"李四");
        helloReflect2.sayHello();
    }
}
