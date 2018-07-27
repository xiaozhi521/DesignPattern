package org.cn.structure.adapter.method2;

/**
 *  圆形桩
 */
public class RoundPeg implements IRoundPeg{
    public void insertIntoHole(String str){
        System.out.println("RoundPeg insertIntohole():"+str);
    }
}
