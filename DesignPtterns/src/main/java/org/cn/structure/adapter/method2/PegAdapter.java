package org.cn.structure.adapter.method2;

/**
 *  现在有个需求，需要既打方形桩，又要打圆形桩，没有源码或者再不改变源码的情况下实现。
 *  使用 Adapter 实现
 */
public class PegAdapter implements IRoundPeg , ISquarePeg {
    private RoundPeg roundPeg;

    private SquarePeg squarePeg;

    // 构造方法
    public PegAdapter(RoundPeg roundPeg){this.roundPeg=roundPeg;}
    // 构造方法
    public PegAdapter(SquarePeg squarePeg){this.squarePeg=squarePeg;}


    public void insert(String str){ roundPeg.insertIntoHole(str);}
    public void insertIntoHole(String str) {

    }
}
