package org.cn.structure.proxy.image;

public class BigImageTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Image image = new BigImage();
        System.out.println("系统得到Image对象的耗时时间：" + (System.currentTimeMillis() - start) + "s");
        image.show();

        /**
         * 图片装载成功。。。
         * 系统得到Image对象的耗时时间：4s
         * 绘制实际的大图片
         */

        long start1 = System.currentTimeMillis();
        ImageProxy imageProxy = new ImageProxy(null);
        System.out.println("使用代理系统得到Image对象的耗时时间：" + (System.currentTimeMillis() - start1) + "s");
        imageProxy.show();

        /**
         * 使用代理系统得到Image对象的耗时时间：0s
         * 图片装载成功。。。
         * 绘制实际的大图片
         */
    }
}
