package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class PackEvent extends ApplicationEvent {

    public PackEvent(Object source) {
        super(source);
    }
}
