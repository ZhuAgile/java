package com.zmy.java.thread01;

/**
 * 改变线程优先级
 */
public class PriorityTest extends Thread {

    public PriorityTest(String name) {
        super(name);
    }

    private int i = 0;

    @Override
    public void run() {
        for (;i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                PriorityTest pr1 = new PriorityTest("低优先级线程");
                pr1.start();
                System.out.println("线程pr1初创的优先级是："+ pr1.getPriority());
                pr1.setPriority(Thread.MIN_PRIORITY);
            }

            if (i == 20) {
                PriorityTest pr2 = new PriorityTest("高优先级线程");
                pr2.start();
                System.out.println("线程pr2初创的优先级是："+ pr2.getPriority());
                pr2.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
