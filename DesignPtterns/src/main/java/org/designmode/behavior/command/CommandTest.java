package org.designmode.behavior.command;

public class CommandTest {
    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] target = {1,2,4,6,8};
        processArray.each(target, new Command() {
            public void process(int[] target) {
                for(int i : target){
                    System.out.println(i);
                }
            }
        });

        processArray.each(target, new Command() {
            public void process(int[] target) {
                int sum = 0;
                for(int i : target){
                    sum += i;
                }
                System.out.println(sum);
            }
        });
    }
}
