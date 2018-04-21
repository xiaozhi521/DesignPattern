package org.cn.proxy.dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokationHandle implements InvocationHandler {

    //需要被代理的对象
   private Object target;

   public void setTarget(Object target){
       this.target = target;
   }
    //执行动态代理对象所有的方法时，都会被替换成执行如下的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       TxUtil txUtil = new TxUtil();
       txUtil.beginTx();
       Object result = method.invoke(target,args);
       txUtil.endTx();
       return result;
    }
}
