package org.cn.structure.bridge;

public abstract class AbstractNoodle {
    //组合一个Peppery 变量，用于将该维度的变化独立出来
    protected Peppery peppery;

    //每份 noodle 必须组合一个 Peppery 对象
    public AbstractNoodle(Peppery peppery){
        this.peppery = peppery;
    }

    public abstract void eat();
}
