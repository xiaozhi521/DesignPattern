package org.designmode.structure.proxy.dog;

import java.lang.reflect.Proxy;

/**
 * 该对象专为指定的target生成动态代理实例
 */
public class MyProxyFactory {
    public static Object getProxy(Object target){
        //创建一个 MyInvokationHandle 对象
        MyInvokationHandle myInvokationHandle = new MyInvokationHandle();
        //w为 MyInvokationHandle 设置target对象
        myInvokationHandle.setTarget(target);
        //创建并返回一个动态代理
        /**
         * newProxyInstance方法用来返回一个代理对象
         * 这个方法总共有3个参数
         * ClassLoader loader用来指明生成代理对象使用哪个类装载器
         * Class<?>[] interfaces用来指明生成哪个对象的代理对象，通过接口指定
         * InvocationHandler h用来指明产生的这个代理对象要做什么事情
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),myInvokationHandle);
    }
}
