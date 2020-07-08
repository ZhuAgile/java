package com.zmy.java.thread01.xianchengtongbu.p01;

/**
 * 线程同步：
 * 线程安全问题：银行取钱问题
 * 1.用户输入账户、密码，系统判断用户的账户、密码是否匹配
 * 2.用户输入取款金额
 * 3.系统判断账户余额是否大于取款金额
 * 4.如果金额大于取款金额，则取款成功；如果余额小于取款金额，则取款失败
 */
public class Account {
    private String accountNo;  // 账户
    private double balance; // 存款余额

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account)obj;
            return target.getAccount().equals(accountNo);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
