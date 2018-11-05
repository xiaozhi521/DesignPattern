package org.cn.behavior.observer.product_spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 第1.2步： 监听订单事件，并打包
 */
@Component
public class FastMailObserverNew implements ApplicationListener<PackageEvent> {


    @Override
    public void onApplicationEvent(PackageEvent packageEvent) {
        String name = packageEvent.getMsg();
        String fastEmail = packageEvent.getFastEmail();
        System.out.println("开始对" + name + "使用" + fastEmail +"进行派送");
    }
}
