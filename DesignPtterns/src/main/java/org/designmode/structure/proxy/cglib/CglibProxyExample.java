package org.designmode.structure.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CHLIB 动态代理。优势在于不需要提供接口。只需要一个抽象类就能实现动态代理
 */
public class CglibProxyExample implements MethodInterceptor {

    public Object getProxy(Class cls){
        //CGLIB 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }


    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 调用真实对象之前");
        //cglib 反射调用真实对象方法
        Object object = methodProxy.invokeSuper(proxy,objects);
        System.out.println("cglib 调用真实对象之后");
        return object;
    }
}
