package com.marcus.pc;

public class TestPc2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watch(tv).start();
    }
}


// 生产者-->演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    tv.play("X-Art");
                } else {
                    tv.play("maDou");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 消费者-->观众
class Watch extends Thread {
    Tv tv;

    public Watch(Tv tv) {
        this.tv = tv;
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 20; i++) {
                tv.watch();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tv {
    // 演员表演，观众等待 T
    //观众观看，演员等待 F
    private String voice;
    private boolean flag = true;

    // 表演
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        System.out.println("演员表演了" + voice);
        // 通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }

    public synchronized void watch() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        System.out.println("观众观看了" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}