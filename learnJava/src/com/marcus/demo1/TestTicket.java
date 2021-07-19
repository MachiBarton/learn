package com.marcus.demo1;

public class TestTicket implements Runnable {

    private int ticketCount = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketCount <= 0) {
                System.out.println("不好意思没票了");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + (11 - ticketCount) + "票");
            ticketCount--;
        }
    }

    public static void main(String[] args) {

        TestTicket testTicket = new TestTicket();

        new Thread(testTicket, "jack").start();
        new Thread(testTicket, "sam").start();
        new Thread(testTicket, "felix").start();
    }
}
