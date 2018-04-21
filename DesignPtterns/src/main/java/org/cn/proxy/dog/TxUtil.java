package org.cn.proxy.dog;

/**
 *  假设该目标对象实例的两个方法不能满足实际需要，
 *  因此客户端不想直接调用该目标对象。
 *  假设客户端需要在GunDog 为两个方法增加事物控制:
 *      在目标方法被调用之前开始事务，在目标方法被调用之后结束事务
 *
 */
public class TxUtil {
    public void beginTx(){
        System.out.println("===模拟事务开启===");
    }
    public void endTx(){
        System.out.println("===模拟事务结束===");
    }
}
