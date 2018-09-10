package org.cn.behavior.observer.product;

public class NameObserver implements Observer {
    public void update(Observer Observer, Object object) {
        if(object instanceof String){
            //将产品名称改变值放在name中
            System.out.println();
        }
    }
}
