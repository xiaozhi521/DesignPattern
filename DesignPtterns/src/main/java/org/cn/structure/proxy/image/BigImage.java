package org.cn.structure.proxy.image;

public class BigImage implements Image {

    public BigImage(){
        try {
            Thread.sleep(3);
            System.out.println("图片装载成功。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        System.out.println("绘制实际的大图片");
    }
}
