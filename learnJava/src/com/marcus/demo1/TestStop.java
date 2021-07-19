package com.marcus.demo1;

// 测试线程stop
//1.建议线程正常停止--->利用次数，不建议死循环
//2.建议使用标识位--->设置一个标志位
//3.不要使用stop或者destroy等过时或者jdk不建议的方法
public class TestStop {

    // 标志
    private static boolean flag = true;
    private static int num = 0;


    public static void main(String[] args) {

        new Thread(() -> {
            int i = 0;
            while (flag) {
                System.out.println(num + "运行" + i++);
            }
        }).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main" + i);
            num = i;
            if (i == 100) {
                flag = false;
                System.out.println("线程停止");
            }
        }
    }
}
