package com.marcus.demo1;

public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(10000, "家庭");

        Thread my = new Thread(new Drawing(account, 3000), "自己");
        Thread wife = new Thread(new Drawing(account, 8000), "wife");

        my.start();
        wife.start();
    }
}

class Account {
    private int money; //余额
    private String name; //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


// 银行：模拟取款

class Drawing implements Runnable {
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
//        this.nowMoney = nowMoney;
    }

    @Override
    public void run() {

        // 判断钱
        if (this.account.getMoney() - this.drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够了呀");
            return;
        }

        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 卡内余额
        this.account.setMoney(this.account.getMoney() - this.drawingMoney);

        //你手里的钱
        this.nowMoney = this.nowMoney + this.drawingMoney;
        System.out.println(Thread.currentThread().getName() + ":" + this.nowMoney);
        System.out.println(this.account.getName() + ",账户余额还有" + this.account.getMoney() + "元。");
    }

}