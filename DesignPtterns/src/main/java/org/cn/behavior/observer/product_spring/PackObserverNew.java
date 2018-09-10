package org.cn.behavior.observer.product_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 第1.2步： 监听订单事件，并打包
 */
@Component
public class PackObserverNew implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        String name = orderEvent.getMsg();
        System.out.println("开始" + name + "包装");
    }
}
