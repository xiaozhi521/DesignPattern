package org.cn.structure.flyweight.cd_example;

/**
 *  享元类
 */
public class Artist {
    private String name;

    Artist(String name){
        System.out.println("创建Artist对象");
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
