package com.zmy.java.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.blockingQueue
 * @projectName : project01
 * @date : 2020-05-28 15:10
 *
 *
 *
 *  利用阻塞队列实现生产者消费者
 **/

class MyResource{
    private volatile boolean FLAG = true;  // 总开关 使用volatile关键字，多线程之间可见
    private AtomicInteger atomicInteger = new AtomicInteger();  // 多线程之间用AtomicInteger,不用number++，防止带来额外的多线程问题
    BlockingQueue<String> blockingQueue = null;  // 使用传接口的方式实现多态，调用方想用什么实现类都可以

    // 使用构造注入的方式来选择哪个接口实现类
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myPro() throws InterruptedException {
        String data = null;
        boolean resultFlag;

        while(FLAG){ // 总开关打开，就干活
            data = atomicInteger.incrementAndGet() + "";

            // 将生产的数据存入到阻塞队列中
            resultFlag = blockingQueue.offer(data,2, TimeUnit.SECONDS);

            if(resultFlag) {
                System.out.println(Thread.currentThread().getName() + "\t " + "插入数据成功！" + data);
            }else {
                System.out.println(Thread.currentThread().getName() + "\t " + "插入数据失败！" + data);
            }

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + "大老板发话，结束生产！");

    }

    public void myConsumer() throws InterruptedException { // 生产者生产后，消费者就从消费队列中去数据
        String result;
        while(FLAG){
            result = blockingQueue.poll(2,TimeUnit.SECONDS);  // 每两秒钟取一次数据

            if(result != null && !"".equals(result)) {
                System.out.println(Thread.currentThread().getName() + "\t" + "取出数据成功！" + result);
            }else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "取出数据失败！消费队列已为空!");
                return;
            }
        }

    }

    // 大老板叫停
    public void stop(){
        FLAG = false;
    }

}


public class ProdConsumerBlockingDemo {
    public static void main(String[] args) throws InterruptedException {
        /*MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(5));

        new Thread(()->{
            try {
                System.out.println("生产线程启动 " + Thread.currentThread().getName());
                myResource.myPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                System.out.println("消费线程启动 " + Thread.currentThread().getName());
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();



        System.out.println();
        System.out.println();
        System.out.println();

        TimeUnit.SECONDS.sleep(5);
        System.out.println();
        System.out.println();
        System.out.println("5秒钟中后停止生产和消费");

        myResource.stop();*/

        System.out.println(Runtime.getRuntime().availableProcessors());
    }


        /*new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                myResource.myPro();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 5秒后，停止生产和消费
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("");
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();
    }*/


}
