package com.zmy.java.thread01;

/**
 * Thread提供了让一个线程等待另一个线程完成的方法--join()方法。当在某个程序执行流中调用其他线程的join()方法
 * 时，调用线程将被阻塞，直到被join()方法加入的join线程执行完毕为止。
 */
public class JoinThread extends Thread{

    public JoinThread(String name) {
       super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子线程
        new JoinThread("新线程").start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被join的线程");
                jt.start();

                // main线程调用了jt线程的join()方法，main线程
                // 必须等jt执行结束才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
