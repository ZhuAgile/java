package com.zmy.java.thread01.xianchengtongbu.p05;

public class DepositThread extends Thread {
    // 模拟用户账户
    private Account account;
    // 当前线程所希望存的钱数
    private double depositAmount;

    public DepositThread(String name,Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    // 重复100次执行存款操作
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            account.deposit(depositAmount);
        }
    }
}
