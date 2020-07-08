package com.zmy.java.thread01.xianchengtongbu.p03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步：
 * 线程安全问题：银行取钱问题
 * 1.用户输入账户、密码，系统判断用户的账户、密码是否匹配
 * 2.用户输入取款金额
 * 3.系统判断账户余额是否大于取款金额
 * 4.如果金额大于取款金额，则取款成功；如果余额小于取款金额，则取款失败
 *
 * 使用Lock锁显示定义同步锁对象来实现线程同步
 */
public class Account {
    private String accountNo;  // 账户
    private double balance; // 存款余额

    private final ReentrantLock lock = new ReentrantLock();

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Account() {
    }

    /*
     * 根据accountNo来重写hash()和equals()方法
     */

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account)obj;
            return target.getAccount().equals(accountNo);
        }

        return false;
    }

    // 提供一个线程安全的方法来完成取钱操作
    public  void draw (double drawMoney) {
        lock.lock();
        try{
            // 账户余额大于取钱线程
            if (balance > drawMoney) {
                System.out.println("操作中，请稍后！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 取钱成功，修改余额
                System.out.println(Thread.currentThread().getName() +" 取钱成功！吐出钞票: " + drawMoney);
                balance -= drawMoney;
                System.out.println(Thread.currentThread().getName() + "当前账户余额为: " + balance);
            }else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        }finally {
            lock.unlock();
        }

    }


    public String getAccount() {
        return accountNo;
    }

    public void setAccount(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }
    // 因为账户余额不允许随便修改，因此只为balance提供getter方法
}
