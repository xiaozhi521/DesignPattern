package org.cn.proxy.image;

/**
 * 这是 bigIamge 的代理对象
 */
public class ImageProxy implements Image {
    private Image image;

    public ImageProxy(Image image){
        this.image = image;
    }
    public void show() {
        if(image == null){
            image = new BigImage();
        }
        image.show();
    }
}
