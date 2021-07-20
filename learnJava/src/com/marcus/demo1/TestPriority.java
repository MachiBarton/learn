package com.marcus.demo1;

public class TestPriority {

    public static final Runnable MyPriority = ()->{
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
    };

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
        Thread t1 = new Thread(MyPriority);
        Thread t2 = new Thread(MyPriority);
        Thread t3 = new Thread(MyPriority);
        Thread t4 = new Thread(MyPriority);
        Thread t5 = new Thread(MyPriority);
        Thread t6 = new Thread(MyPriority);

        t1.start();
        t2.setPriority(1);
//设置优先级
        t3.setPriority(2);

        t6.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t3.start();
        t6.start();
        t4.setPriority(3);
        t4.start();

        t5.setPriority(4);
        t5.start();


    }
}
