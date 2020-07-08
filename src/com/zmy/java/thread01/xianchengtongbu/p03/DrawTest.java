package com.zmy.java.thread01.xianchengtongbu.p03;

public class DrawTest {

    public static void main(String[] args) {
        // 创建一个账户
        Account account = new Account("123456",1500);

        new DrawThread("甲",account,1000).start();
        new DrawThread("乙",account,1000).start();

    }
}
