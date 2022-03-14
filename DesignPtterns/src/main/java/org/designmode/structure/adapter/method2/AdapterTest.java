package org.designmode.structure.adapter.method2;


public class AdapterTest {
    public static void main(String[] args) {
        PegAdapter pegAdapter = new PegAdapter(new RoundPeg());

        pegAdapter.insert("打桩");
    }
}
