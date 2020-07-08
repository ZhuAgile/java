package com.zmy.java.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.blockingQueue
 * @projectName : project01
 * @description : SynchronousQueue没有容量，与其他BlockingQueue不同，SynchronousQueue是一个不存储的BlockingQueue，
 *                每一个put操作必须等待一个take操作，否者不能继续添加元素
 * @date : 2020-05-28 00:20
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{

            try {
                System.out.println(Thread.currentThread().getName() + " put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + " put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + " put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"t1").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " remove a");
                blockingQueue.take();

                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " remove b");
                blockingQueue.take();

                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " remove c");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"t2").start();
    }
}
