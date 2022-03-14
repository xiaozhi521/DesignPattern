package org.designmode.structure.proxy.jdk;

import org.designmode.structure.proxy.dog.Dog;
import org.designmode.structure.proxy.dog.GunDog;

public class Test {
    public static void main(String[] args) {
        JdkProxyExample  jdkProxyExample = new JdkProxyExample();
        Dog gunDog = (Dog) jdkProxyExample.bind(new GunDog());
        gunDog.info();
        gunDog.run();
    }
}
