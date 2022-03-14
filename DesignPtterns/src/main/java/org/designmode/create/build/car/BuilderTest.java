package org.designmode.create.build.car;

public class BuilderTest {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director( builder );
        director.construct();
        Product product = builder.getResult();

    }
}
