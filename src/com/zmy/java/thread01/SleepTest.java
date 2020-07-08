package com.zmy.java.thread01;

import java.util.Date;

/**
 * 线程睡眠；sleep
 * 如果需要让当前正在执行的线程暂停一段时间，并进入阻塞状态，则可以通过调用Thread类的静态方法
 * sleep()方法来实现。
 *
 * 当当前线程调用sleep()方法进入阻塞状态后，在起睡眠的时间段内，该线程不会获得执行的机会，即使
 * 系统中没有其他可执行的线程，处于sleep()中的线程也不会执行，因此sleep()方法常用来暂停程序的执行。
 *
 * Thread还提供了一个与sleep()方法有点儿相似的yield()方法，它也可以让当前正在执行的线程暂停，
 * 但它不会阻塞该线程，它只是将该线程转入就绪状态。yield()只是让当前线程暂停一下，让系统的调度器
 * 重新调度一次，完全可能的情况是：当某个线程调用了yield()方法暂停之后，线程调度器又将其调度出来重新
 * 执行。
 *     实际上，当某个线程调用了yield()方法暂停之后，只有优先级与当前线程相同，或者优先级比当前线程更高
 * 的处于就绪状态的线程才会获得执行的机会。
 *
 * sleep()方法和yield)()方法的区别如下：
 * （1）sleep()方法暂停当前线程后，会给其他线程执行机会，不会理会其他线程的优先级；但yield()方法只会给优先级
 *      相同，或者优先级更高的线程执行机会；
 * （2）sleep()方法会将线程转入阻塞状态，直到经过阻塞时间才会转入就绪状态；而yield()不会将线程转入阻塞状态，
 *     它只是强制当前线程进入就绪状态。因此完全有可能某个线程被yield()方法暂停之后，立即再次获得处理器资源
 *     被执行。
 * （3）sleep()方法抛出了InterruptedException异常，所以调用sleep()方法时要么捕捉该异常，要么显示声明抛出该
 *     异常；而yield()方法则没有声明抛出任何异常。
 * （4）sleep()方法比yield()方法有更好的可移植性，通常不建议使用yield()方法来控制并发编程的执行。
 *
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间：" + new Date());
//            Thread.sleep(1000);
            Thread.yield();
        }

    }
}
