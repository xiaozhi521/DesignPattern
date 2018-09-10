package org.cn.behavior.observer.product_jdk;

public class Test {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        JingdongObserver jingdongObserver = new JingdongObserver();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        productList.addObserver(jingdongObserver);
        productList.addObserver(taoBaoObserver);

        productList.addProduct("干果榛子");
    }
}
