package org.cn.create.build;

/**
 * Builder 的具体实现 ConcreteBuilder
 * 通过具体完成接口 builder 来构建或装配产品的部件
 * 定义并明确他所要创建的是什么具体东西
 */
public class ConcreteBuilder implements Builder {
    Part partA, partB, partC;
    public void buildPartA() {
        //这里是具体如何构建partA 的代码
    }

    public void buildPartB() {
        //这里是具体如何构建partA 的代码
    }

    public void buildPartC() {
        //这里是具体如何构建partA 的代码
    }

    public Product getResult() {
        //返回最后的组装结果
        return null;
    }
}