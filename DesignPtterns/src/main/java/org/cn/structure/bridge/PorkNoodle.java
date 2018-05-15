package org.cn.structure.bridge;

public class PorkNoodle extends AbstractNoodle {
    public PorkNoodle(Peppery peppery) {
        super(peppery);
    }

    public void eat() {
        System.out.println("这是一碗油腻的猪肉面条。" + super.peppery.style());
    }
}
