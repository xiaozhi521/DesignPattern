package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 第1.1步： 创建订单事件
 */
@Component
public class PackageEvent extends ApplicationEvent {
    private String name;

    private String fastEmail;

    public PackageEvent(Object source) {
        super(source);
    }

    public String getMsg() {
        return name;
    }

    public void setMsg(String msg) {
        this.name = msg;
    }

    public String getFastEmail() {
        return fastEmail;
    }

    public void setFastEmail(String fastEmail) {
        this.fastEmail = fastEmail;
    }
}
