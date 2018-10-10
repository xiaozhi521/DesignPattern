package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 第1.1步： 创建订单事件
 */
@Component
public class OrderEvent extends ApplicationEvent {
    private String name;

    public OrderEvent(Object source) {
        super(source);
    }

    public String getMsg() {
        return name;
    }

    public void setMsg(String msg) {
        this.name = msg;
    }
}
