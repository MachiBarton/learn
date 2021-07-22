package com.marcus.demo1;

public class TestSynchronized {

    public static void main(String[] args) {

        BuyTicket station = new BuyTicket();

        new Thread(station,"felix").start();
        new Thread(station,"barton").start();
        new Thread(station,"jam").start();
    }

}

class BuyTicket implements Runnable {

    // 票
    private int ticketNum = 10;
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {

        //判断是否有票
        if (ticketNum <= 0) {
            System.out.println(Thread.currentThread().getName() + ",手慢啦，没有抢到");
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "抢到了第" + (11 - ticketNum) + "张票");

        ticketNum--;
    }
}