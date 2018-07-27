package org.cn.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 *  通过反射生成带有参数的构建方法
 */
public class ReflectServiceImpl2 {
    private String name;
    public ReflectServiceImpl2(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("hello " + name);
    }

    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;
        try {
            /**
             *  如下代码反射生成对象
             *
             */

            object = (ReflectServiceImpl2) Class.forName("org.cn.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ReflectServiceImpl2 reflectServiceImpl2 = new ReflectServiceImpl2("111");
        reflectServiceImpl2.getInstance();
    }
}
