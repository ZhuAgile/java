package com.zmy.java.thread01;

public class FirstThread extends Thread{
    // 使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量
    private  int i = 0;

    @Override
    public void run() {
        for (; i<100; i++) {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        for (int i = 0; i<100; i++) {
            System.out.println(Thread.currentThread().getName());
            if (i == 20) {
                // 创建并启动第一个线程
                new FirstThread().start();
                // 创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }
}
