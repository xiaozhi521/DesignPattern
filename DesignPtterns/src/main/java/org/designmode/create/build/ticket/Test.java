package org.designmode.create.build.ticket;

public class Test {
    public static void main(String[] args) {
        TickketHelper tickketHelper = new TickketHelper();
        tickketHelper.buildAdult("成人票");
        tickketHelper.buildChildForSeat("儿童有座");
        tickketHelper.buildChildForSeat("儿童无座");
        TicketBuilder.builder(tickketHelper);
    }
}
