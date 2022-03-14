package org.designmode.behavior.observer.product_spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  Spring 的事件需要遵循如下流程：
 *  1、自定义事件，集成 ApplicationEvent
 *  2、自定义监听事件，实现 ApplicationListener
 *  3、使用容器发布事件
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.saveOrder("榛子");
        PackageService packageService = context.getBean(PackageService.class);
        packageService.createpackage("榛子","EMS");
    }
}
