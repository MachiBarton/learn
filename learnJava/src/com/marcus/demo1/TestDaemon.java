package com.marcus.demo1;

public class TestDaemon {
    public static final Runnable Persion=()->{
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着");
        }
        System.out.println("再见👋");
    };

    public static final Runnable God=()->{
      while(true){
          System.out.println("无涯");
      }
    };

    public static void main(String[] args) {

        Thread thread = new Thread(God);
        thread.setDaemon(true); //默认是false
        thread.start();

        new Thread(Persion).start();
    }
}
