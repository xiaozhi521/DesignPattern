package org.cn.structure.proxy.cglib;

import org.cn.structure.proxy.dog.GunDog;

/**
 *  cglib 测试-- 以 GunDog 为例
 */
public class Test {
    public static void main(String[] args) {
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        GunDog gunDog = (GunDog) cglibProxyExample.getProxy(GunDog.class);
        gunDog.run();
        gunDog.info();
    }
}
