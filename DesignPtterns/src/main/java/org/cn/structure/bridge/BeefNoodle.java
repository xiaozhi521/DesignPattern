package org.cn.structure.bridge;

public class BeefNoodle extends AbstractNoodle {
    public BeefNoodle(Peppery peppery) {
        super(peppery);
    }

    public void eat() {
        System.out.println("这是一碗美味的牛肉面。" + super.peppery.style());
    }
}
