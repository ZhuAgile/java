package com.zmy.java.thread01;

public class SecondThread implements  Runnable{
    // 使用实现Runnable接口的方法来创建线程类时，多个线程之间可以共享线程类的实例变量
    private int i = 1;

    @Override
    public void run() {
        for (; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() +" "+ i);
        }
    }

    public static void main (String[] args) {
        Thread.currentThread().setName("主线程");
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() +" "+ i);
            if (i == 20) {
                SecondThread s1 = new SecondThread();
                // 通过new Thread(target,name)方式来创建线程
                new Thread(s1,"线程1").start();
                new Thread(s1,"线程2").start();

            }
        }

    }
}
