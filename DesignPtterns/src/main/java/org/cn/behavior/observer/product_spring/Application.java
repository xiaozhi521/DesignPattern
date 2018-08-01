package org.cn.behavior.observer.product_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("org.cn.behavior.observer.product_spring")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        OrderService orderService = new OrderService();
        orderService.saveOrder("榛子");
    }
}
