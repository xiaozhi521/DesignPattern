package org.cn.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloReflectInstance {

    /**
     *  反射类
     * @return
     */
    public static HelloReflect getInstance(){
        HelloReflect helloReflect = null;
        try {
            helloReflect = (HelloReflect) Class.forName("org.cn.reflect.HelloReflect").newInstance();
            helloReflect.sayHello("zhan");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return helloReflect;
    }

    /**
     * 反射方法
     * @return
     */
    public static Object reflectMethod(){
        Object object = null;
        HelloReflect helloReflect = new HelloReflect();
        try {
            Method method = HelloReflect.class.getMethod("sayHello", String.class);
            object = method.invoke(helloReflect,"李四");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     *  反射生成对象和反射调度方法
     * @return
     */
    public static Object getReflect(){
        //反射类
        HelloReflect object = null;
        try {
            object = (HelloReflect) Class.forName("org.cn.reflect.HelloReflect").newInstance();
            //反射方法
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"张三");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
