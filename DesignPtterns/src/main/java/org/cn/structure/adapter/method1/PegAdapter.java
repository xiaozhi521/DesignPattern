package org.cn.structure.adapter.method1;

/**
 *  现在有个需求，需要既打方形桩，又要打圆形桩，没有源码或者再不改变源码的情况下实现。
 *  使用 Adapter 实现
 */
public class PegAdapter{
    private SquarePeg squarePeg;

    public PegAdapter(SquarePeg squarePeg){this.squarePeg = squarePeg;}

    public void insertIntohole(String str){
        squarePeg.insert(str);
    }
}
