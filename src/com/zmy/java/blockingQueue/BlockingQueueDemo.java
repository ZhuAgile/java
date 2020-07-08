package com.zmy.java.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.blockingQueue
 * @projectName : project01
 * @date : 2020-05-27 23:44
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        /*// 脾气暴躁老哥，一言不合就抛异常
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
       // System.out.println(blockingQueue.add("x"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/


        // 性格温和的好人 不能插入就提示false，队列没有元素移除时就提示null
        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

        /*// 要求严格面包房，面包柜台放不下了，后面再放的话，需要等柜台上的被买走，否则一直等
        // 当柜台上面包没有了，这时客人买不到面包就一直等着，直到有面包做好放到柜台
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
       // blockingQueue.put("x");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());*/

        // 守时的面包房，当柜台满了时，如果后面面包往柜台放，等了一段时间还没位置，就不往上放了
        // 同时，当柜台面包撤下时，当柜台撤完了而这时还要往下撤，这时按照规定的时间等待，规定的时间完了还没等到，就返回null
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("b",2, TimeUnit.SECONDS);
        blockingQueue.offer("c",2, TimeUnit.SECONDS);
        blockingQueue.offer("d",2, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));


    }
}
