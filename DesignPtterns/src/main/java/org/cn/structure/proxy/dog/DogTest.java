package org.cn.structure.proxy.dog;

public class DogTest {
    public static void main(String[] args) {
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();

    }
}
