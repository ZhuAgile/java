package com.zmy.java.thread01.xianchengtongbu.p01;

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

        /*// 账户余额大于取钱线程
        if (account.getBalance() > drawMoney) {
            System.out.println("操作中，请稍后！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 取钱成功，修改余额
            System.out.println(getName()+" 取钱成功！吐出钞票: " + drawMoney);
            account.setBalance(account.getBalance() - drawMoney);
            System.out.println(getName() + "当前账户余额为: " + account.getBalance());
        }else {
            System.out.println(getName() + "取钱失败！余额不足！");
        }*/

        // 解决线程安全问题，使用同步代码块
        synchronized (account) {
            // 账户余额大于取钱线程
            if (account.getBalance() > drawMoney) {
                System.out.println("操作中，请稍后！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 取钱成功，修改余额
                System.out.println(getName()+" 取钱成功！吐出钞票: " + drawMoney);
                account.setBalance(account.getBalance() - drawMoney);
                System.out.println(getName() + "当前账户余额为: " + account.getBalance());
            }else {
                System.out.println(getName() + "取钱失败！余额不足！");
            }
        }

    }
}
