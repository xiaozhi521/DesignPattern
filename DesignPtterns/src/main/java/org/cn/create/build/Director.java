package org.cn.create.build;

public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }
    //将部件 PartA partB partC 最后组成复杂对象
    //这里是将车轮 方向盘  发动机组成汽车的过程
    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
