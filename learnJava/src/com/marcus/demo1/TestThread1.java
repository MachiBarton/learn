package com.marcus.demo1;

// 创建线程方式一：继承Thread类 重写run方法 调用start开启线程

//线程开始不一定立即执行，服从cpu调度
public class TestThread1 extends Thread {

    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("look code" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        //调用start()方法
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("learn thread" + i);
        }
    }

}
