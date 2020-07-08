package com.zmy.java.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.blockingQueue
 * @projectName : project01
 * @description : 生产者消费者传统模式
 * @date : 2020-05-28 01:08
 *
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 *
 * 思路：
 *     1 线程   操作     资源类
 *     2 判断   干活    通知
 *
 **/

// 资源类
class SharedData{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();  // Lock锁的 await()和 signal()方法

    // 加1操作方法
    public void incrementNumber(){
        lock.lock();
        try {
            while(number != 0){  // 使用while来判断而不使用if来判断，目的是防止底层伪唤醒
                condition.await();
            }

            this.number++;
            System.out.println(Thread.currentThread().getName() + " " + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    // 减1操作方法
    public void decrementNumber() {
        lock.lock();


            try {
                while(number == 0){ // 使用while来判断而不使用if来判断，目的是防止底层伪唤醒
                    condition.await();
                }

                this.number--;
                System.out.println(Thread.currentThread().getName() + " " + number);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }



    }

}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        new Thread(()->{
            for (int i = 1; i <= 5 ; i++) {
                sharedData.incrementNumber();
            }
        },"AA").start();


        new Thread(()->{
            for (int i = 1; i <= 5 ; i++) {
                sharedData.decrementNumber();
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 1; i <= 5 ; i++) {
                sharedData.incrementNumber();
            }
        },"CC").start();


        new Thread(()->{
            for (int i = 1; i <= 5 ; i++) {
                sharedData.decrementNumber();
            }
        },"DD").start();

    }
}
