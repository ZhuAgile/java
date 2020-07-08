package com.zmy.java.thread01.xianchengtongbu.p05;

public class DrawTest {

    public static void main(String[] args) {
        // 创建一个账户
        Account account = new Account("123456",0);

        new DrawThread("取钱者",account,1000).start();
        new DepositThread("存款者甲",account,1500).start();
        new DepositThread("存款者乙",account,1000).start();
        new DepositThread("存款者丙",account,1000).start();

    }
}
