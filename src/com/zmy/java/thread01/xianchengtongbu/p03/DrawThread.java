package com.zmy.java.thread01.xianchengtongbu.p03;

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

    // 多个线程修改同一个共享数据时，将涉及数据安全问题
    @Override
    public void run() {
        account.draw(drawMoney);
    }
}
