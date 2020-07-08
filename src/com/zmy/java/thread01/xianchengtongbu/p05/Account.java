package com.zmy.java.thread01.xianchengtongbu.p05;

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
    // 标识账户中是否已有存款的旗标
    private boolean flag = false;

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

    // 取款方法
    public synchronized  void draw(double drawAmount) {
        try {
            // 如果flag为false，则表示账户中还没有人进行存款，取钱方法阻塞；
            if (!flag) {
                wait();
            }else {
                // 执行取钱操作
                System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                // 将标识账户是否已有存款的旗标设为false
                flag = false;
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // 存款方法
    public synchronized void deposit(double depositAmount){
        try {
            // 如果flag为true,则表明账户中已有人存款，则当前存款操作阻塞
            if (flag) {
                wait();
            }else {
                // 执行存款操作
                System.out.println(Thread.currentThread().getName() + " 存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("当前账户余额为：" + balance);
                // 将表示账户是否已有存款的旗标设为true
                flag = true;
                // 唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
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
