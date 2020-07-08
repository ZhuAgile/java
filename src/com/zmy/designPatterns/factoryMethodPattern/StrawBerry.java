package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 21:53
 * @description :
 **/
public class StrawBerry implements Fruit {
    @Override
    public void grow() {
        log("草莓正在生长....");
    }

    @Override
    public void harvest() {
        log("草莓正在被采摘....");
    }

    @Override
    public void plant() {
        log("草莓正在被种下....");
    }

    static void log(String msg){
        System.out.println(msg);
    }
}
