package com.zmy.java.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.blockingQueue
 * @projectName : project01
 * @date : 2020-05-28 02:08
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * synchronized和Lock有什么区别？用新的Lock有什么好处？你举例说说
 * 1.原始构成
 * ​     synchronized是关键字，属于JVM层面，
 * ​			monitorenter（底层是通过monitor对象来完成，其实wait/notiry等方法也依赖于monitor对象只有在同步块或方法中才能调wait/notify等方法。）
 *          monitorexit
 *
 * ​     Lock是具体类（java.util.concurrent.locks.Lock）是API层面的锁。
 *
 * 2.使用方法
 *      synchronized 不需要用户去手动释放锁，当synchronized代码执行完后系统会自动让线程释放对锁的占用
 *      ReentrantLock则需要用户去手动释放锁，若没有主动释放锁，就有可能导致出现死锁现象。需要lock()和unlock()方法配合try/finally语句块来完成。
 *
 * 3.等待是否可中断
 *      synchronized不可中断，除非抛出异常或者正常运行完成
 *      ReentrantLock可中断，1.设置超时方法tryLock(long timeout,TimeUnit unit)
 *                          2.lockInterruptibly()放代码块中，调用interrupt()方法可中断。
 *
 * 4.加锁是否公平
 *      synchronized非公平锁。
 *      ReentrantLock两者都可以，默认公平锁，构造犯法可以传入boolean值，true为公平锁，false为非公平锁
 *
 * 5.锁绑定多个条件Condition
 *      synchronized没有
 *      ReentrantLock用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像synchronized要么随机唤醒一个要么唤醒全部线程。
 *
 *
 *  题目；多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 *  AA打印5次，BB打印10次，CC打印15次
 *  紧接着
 *  AA打印5次，BB打印10次，CC打印15次
 *  ...
 *  来10轮
 *
 *  结题思路：判断，干活，通知
 **/
class ShareData{
    private int number = 1;
    Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();

    Condition condition2 = lock.newCondition();

    Condition condition3 = lock.newCondition();

    // AA打印，然后唤醒BB
    public void print5(){
        lock.lock();

        try {
            // 防止伪唤醒
            while(number != 1) {  // 判断
                condition1.await();
            }

            // 干活
            for (int i = 1; i <= 5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            number = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    // BB打印，然后唤醒CC
    public void print10(){
        lock.lock();

        try {
            // 防止伪唤醒
            while(number != 2) {  // 判断
                condition2.await();
            }

            // 干活
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            number = 3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // CC打印，然后唤醒AA
    public void print15(){
        lock.lock();

        try {
            // 防止伪唤醒
            while(number != 3) {  // 判断
                condition3.await();
            }

            // 干活
            for (int i = 1; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            number = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                shareData.print5();
            }

        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                shareData.print10();
            }

        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                shareData.print15();
            }

        },"CC").start();
    }
}
