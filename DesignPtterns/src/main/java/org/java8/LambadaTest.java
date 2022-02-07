package org.java8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author mu_qingfeng
 * @date 2022/2/3 3:28 PM
 *
 * java 内置4大核心函数式接口
 *  - 消费型接口 Consumer<T> void accept(T t)
 *  - 供给型接口 Supplier<T> T get()
 *  - 函数型接口 Function<T, R> R apply(T t)
 *  - 断定型接口 Predicate<T> boolean test(T t)
 */
public class LambadaTest {

    @Test
    public void test1() {

        handlerPrice(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("张三去天上人间买了一瓶水，花了" + aDouble);
            }
        });

        System.out.println("***************");

        handlerPrice(400,money -> System.out.println("李四去天上人间买了一瓶水，花了" + money));
    }
    public void handlerPrice(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("地瓜","西瓜", "西红柿", "南瓜","冬瓜","黄瓜");
        List<String> listStr = handlerString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("瓜");
            }
        });
        System.out.println(listStr);

        List<String> listStr2 = handlerString(list, s -> s.contains("瓜"));
        System.out.println(listStr2);

    }



    public List<String> handlerString(List<String> list, Predicate<String> pre){
        List<String> listStr = new ArrayList<>();

        for(String str : list){
            if (pre.test(str)){
                listStr.add(str);
            }
        }
        return listStr;
    }

    /**
     *  方法引用
     */
    @Test
    public void test3(){
        Comparator<String> com = (s1, s2) -> s1.compareTo(s2);

        System.out.println(com.compare("aaa", "abc"));

        Comparator<String> com2 = String::compareTo;

        System.out.println(com2.compare("aaa", "abc"));


    }
}
