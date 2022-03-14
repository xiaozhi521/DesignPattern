package org.designmode.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements SmartApplicationListener {
    //监听哪一种事件
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    //当事件发生时执行
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("创建订单成功，开始打包操作");
    }

    //定义多个监听者的执行顺序
    @Override
    public int getOrder() {
        //值越大，顺序越往后
        return 60;
    }
}
