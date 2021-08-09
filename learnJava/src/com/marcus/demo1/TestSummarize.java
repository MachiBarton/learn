package com.marcus.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestSummarize {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "Runnable");
        thread2.start();

        Thread3 thread3 = new Thread3();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(thread3);
        new Thread(futureTask).start();
        futureTask.get();
    }
}

// 继承 Thread 类
class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName());
    }

}

class Thread2 implements Runnable {

    @Override
    public void run() {

        System.out.println("Runnable:" + Thread.currentThread().getName());

    }
}

class Thread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}