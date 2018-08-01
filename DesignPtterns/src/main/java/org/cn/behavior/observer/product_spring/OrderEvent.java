package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 第一步： 创建订单事件
 */
@Component
public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
