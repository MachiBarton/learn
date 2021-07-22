package com.marcus.demo1;

public class TestDeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0,"yy");
        MakeUp g2 = new MakeUp(1,"y2");
        g1.start();
        g2.start();
    }
}

class Lipstick{

}

class Mirror{

}

class MakeUp extends Thread{
// 需要资源只有一份，用static来保证只有一份
    static final Lipstick lipstick = new Lipstick();
    static final Mirror mirror = new Mirror();
    int choice; // 选择
    String name; // 使用化妆品的人

    MakeUp( int choice,String name){
        this.choice = choice;
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){ //口红的锁
                System.out.println(this.name+"获取口红的锁");
                Thread.sleep(1000);

            }
            synchronized (mirror){ //一秒钟以后想获得镜子
                System.out.println(this.name+"获得镜子的锁");
            }
        }else{
            synchronized (mirror){ //口红的锁
                System.out.println(this.name+"获得镜子的锁");
                Thread.sleep(1000);

            }
            synchronized (lipstick){ //一秒钟以后想获得镜子
                System.out.println(this.name+"获得口红的锁");
            }
        }
    }
    // 化妆，互相持有对方的锁
}