package org.designmode.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FastMailListener implements SmartApplicationListener {
    //监听哪一种事件
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == PackageEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    //当事件发生时执行
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("打包成功，开始发送快递操作");
    }

    //定义多个监听者的执行顺序
    @Override
    public int getOrder() {
        //值越大，顺序越往后
        return 30;
    }
}
