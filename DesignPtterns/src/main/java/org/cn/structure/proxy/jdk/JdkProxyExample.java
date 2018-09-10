package org.cn.structure.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK 动态代理是java.lang.reflect.*包提供的方式，它必须借助一个接口才能产生代理对象。
 */
public class JdkProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     *  建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target,args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
