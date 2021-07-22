package com.marcus.demo1;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Buy buyTicket = new Buy();
        new Thread(buyTicket, "小张").start();
        new Thread(buyTicket, "小王").start();
        new Thread(buyTicket, "小丑").start();
    }

}

class Buy implements Runnable {

    int ticketNum = 100;
    //定义lock 锁

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "获得第" + (101 - ticketNum) + "票");
                    ticketNum--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "没票了");
                    break;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}