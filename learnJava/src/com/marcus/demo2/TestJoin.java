package com.marcus.demo2;

public class TestJoin {


    private static final Runnable run=()->{
        for(int i = 0;i<5;i++){
//            System.out.println("线程vip来了"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(run);
//       thread.start();
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state = thread.getState();
        System.out.println(state);
        while (state!=Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

    }
}

