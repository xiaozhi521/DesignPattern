package org.cn.create.build;

public class BuilderTest {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director( builder );
        director.construct();
        Product product = builder.getResult();

    }
}
