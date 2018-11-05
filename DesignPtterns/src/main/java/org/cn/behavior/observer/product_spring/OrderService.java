package org.cn.behavior.observer.product_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/** 订单操作 **/
@Service
public class OrderService {
    @Autowired
    ApplicationContext applicationContext;
    /** 创建订单 **/
    public void saveOrder(String name){
        System.out.println("恭喜【" + name + "】购买产品a 成功！！");
        OrderEvent orderEvent = new OrderEvent(this);
        orderEvent.setMsg(name);
        applicationContext.publishEvent(orderEvent);

    }
}
