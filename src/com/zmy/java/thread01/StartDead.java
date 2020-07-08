package com.zmy.java.thread01;

public class StartDead extends Thread {
    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) {
         StartDead sd =  new StartDead();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);

            if (i == 20) {
                // 启动线程
                sd.start();
            }
            System.out.println("子线程当前状态：" + sd.isAlive());
            System.out.println("主线程当前状态：" + Thread.currentThread().isAlive());

            // 当线程处于新建、死亡两种状态时，isAlive()方法返回false
            // 当i>20时，说明线程已经启动过了，如果sd.isAlive()为false时，
            // 那线程就是死亡状态了
            // 死亡状态的线程再调用start()方法时，则会抛出IllegalThreadStateException异常
            /*if (i > 20 && !sd.isAlive()) {
                sd.start();
            }*/
        }

    }
}
