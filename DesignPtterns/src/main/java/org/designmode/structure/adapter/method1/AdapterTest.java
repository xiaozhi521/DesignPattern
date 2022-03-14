package org.designmode.structure.adapter.method1;

public class AdapterTest {
    public static void main(String[] args) {
        PegAdapter pegAdapter = new PegAdapter(new SquarePeg());

        pegAdapter.insertIntohole("打桩");
    }
}
