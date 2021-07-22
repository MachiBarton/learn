package com.marcus.pc;

// 测试：生产者消费者模型 利用缓冲区解决：管程法

public class TestPc {
}

//生产者
class Productor extends Thread {

}

// 消费者
class Consumer extends Thread {

}

//商品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {

    // 需要一个容器
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
            //通知消费者消费，生产等待
        }

        //如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;
    }


    // 消费者消费产品

}