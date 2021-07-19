package com.marcus.demo2;

public class TestLamda {

    public static void main(String[] args) {
        ILove love = (int a)-> {
            System.out.println("ilove");
        };
        love.love(12);
    }
}

interface ILove {
    void love (int a);
}