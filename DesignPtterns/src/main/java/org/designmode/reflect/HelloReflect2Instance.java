package org.designmode.reflect;

import java.lang.reflect.InvocationTargetException;

public class HelloReflect2Instance {
    /**
     *
     * @return
     */
    public static HelloReflect2 getInstance() {
        HelloReflect2 helloReflect2= null;
        try {
            helloReflect2 = (HelloReflect2) Class.forName("org.designmode.reflect.HelloReflect2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return helloReflect2;
    }

    /**
     *
     * @param reference
     * @return
     */
    public static HelloReflect2 getInstance(String reference) {
        HelloReflect2 helloReflect2= null;
        try {
            helloReflect2 = (HelloReflect2) Class.forName(reference).getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return helloReflect2;
    }

    /**
     *
     * @param reference
     * @param clazz
     * @param name
     * @return
     */
    public static HelloReflect2 getInstance(String reference,Class<?> clazz,String name) {
        HelloReflect2 helloReflect2= null;
        try {
            helloReflect2 = (HelloReflect2) Class.forName(reference).getConstructor(clazz).newInstance(name);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return helloReflect2;
    }
}
