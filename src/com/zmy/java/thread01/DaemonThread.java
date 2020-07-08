package com.zmy.java.thread01;

/**
 * 有一种线程，它是在后台运行的，它的任务是为其他的线程提供服务，这种线程被称为“后台线程”，又称为
 * “守护线程”或“精灵线程”。JVM的垃圾回收线程就是典型的后台线程。
 *
 * 后台线程有个特征：如果所有的前台线程都死亡，后台线程会自动死亡
 */
public class DaemonThread extends Thread {

    private int i = 0;
    @Override
    public void run() {
        for (; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        // 将此线程设置为后台线程
        dt.setDaemon(true);
        // 启动线程
        dt.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        // 判断线程是否为后台线程
        System.out.println("dt线程是否为后台线程：" + dt.isDaemon());
        // 判断后台线程是否还存活
        System.out.println("后台线程的存活状态： " + dt.isAlive());

    }
}
