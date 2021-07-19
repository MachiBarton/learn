package com.marcus.demo1;

public class TestYield {

    public static void main(String[] args) {
        Myyield myYield = new Myyield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}


class Myyield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始线程");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}