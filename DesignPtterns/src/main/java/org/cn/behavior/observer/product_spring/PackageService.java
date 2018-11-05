package org.cn.behavior.observer.product_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/** 打包操作 **/
@Service
public class PackageService {
    @Autowired
    ApplicationContext applicationContext;
    /** 创建包裹 **/
    public void createpackage(String name,String fastEmail){
        System.out.println("恭喜【" + name + "】打包成功！！");
        PackageEvent packageEvent = new PackageEvent(this);
        packageEvent.setMsg(name);
        packageEvent.setFastEmail(fastEmail);
        applicationContext.publishEvent(packageEvent);

    }
}
