package com.zmy.designPatterns.simpleFactoryPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 15:52
 * @description :
 **/
public class StrawBerry implements Fruit{
    @Override
    public void grow() {
        log("草莓正在生长....");
    }

    @Override
    public void harvest() {
        log("草莓正在采摘....");
    }

    @Override
    public void plant() {
        log("草莓正在种植....");
    }

    public static void log(String msg){
        System.out.println(msg);
    }
}
