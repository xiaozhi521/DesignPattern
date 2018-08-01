package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PackObserver implements SmartApplicationListener {

    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderEvent.class;
    }

    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == PackObserver.class;
    }

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("开始包装");
    }

    public int getOrder() {
        //值越大，越靠后
        return 500;
    }
}
