package com.zmy.java.thread01;

public class InvokeRun extends Thread {
    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++ ) {
            // 直接调用run()方法时，Thread的this.getName()返回的是该对象的名字
            // 而不是当前线程的名字
            // 使用Thread.currentThread().getName()总是获取当前线程的名字
            //System.out.println(this.getName());
            System.out.println(Thread.currentThread().getName() + " " + i );
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);

            if (i == 20) {
                // 直接调用线程对象的run()方法
                // 系统会把线程对象当成普通对象，把run()方法当成普通方法
                // 所以下面代码并不会启动两个线程，而是依次执行两个run()方法
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}
