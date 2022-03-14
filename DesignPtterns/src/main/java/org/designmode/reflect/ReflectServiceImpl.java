package org.designmode.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    public void sayHello(String name){
        System.out.println("hello " + name);
    }

    //反射生成对象
    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("org.designmode.reflect.ReflectServiceImpl").newInstance();
            object.sayHello("lhz");
        }catch (Exception e){

        }
        return object;
    }
    //反射方法
    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    //反射生成对象和反射调度方法
    public Object reflect(){
        ReflectServiceImpl target = null;
        try {
            target = (ReflectServiceImpl) Class.forName("org.designmode.reflect.ReflectServiceImpl").newInstance();
            Method method = target.getClass().getMethod("sayHello", String.class);
            method.invoke(target,"张三");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException |  NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static void main(String[] args) {
        ReflectServiceImpl reflectService = new ReflectServiceImpl();
        reflectService.getInstance();
    }
}
