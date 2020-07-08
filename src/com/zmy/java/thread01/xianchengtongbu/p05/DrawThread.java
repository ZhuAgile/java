package com.zmy.java.thread01.xianchengtongbu.p05;

public class DrawThread extends Thread {
    // 模拟用户账户
    private Account account;
    // 当前取钱线程所希望取得钱数
    private double drawMoney;

    public DrawThread(String name, Account account, double drawMoney) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    // 重复100次执行取钱操作
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawMoney);
        }

    }
}
