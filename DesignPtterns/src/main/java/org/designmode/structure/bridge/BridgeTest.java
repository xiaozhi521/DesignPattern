package org.designmode.structure.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        // 下面将得到 “辣味” 的牛肉面
        AbstractNoodle noodle = new BeefNoodle(new PepperyStyle());
        noodle.eat();

        //下面将得到不辣的牛肉面
        AbstractNoodle plainBeefNoodle = new BeefNoodle(new PlainStyle());
        plainBeefNoodle.eat();

        // 下面将得到 “辣味” 的猪肉面
        AbstractNoodle pepperyPorkNoodle = new PorkNoodle(new PepperyStyle());
        pepperyPorkNoodle.eat();

        // 下面将得到 不辣 的猪肉面
        AbstractNoodle plainPorkNoodle = new PorkNoodle(new PlainStyle());
        plainPorkNoodle.eat();
    }
}
