package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 21:53
 * @description :
 **/
public class Grape implements Fruit {

    private boolean seedless;

    public boolean isSeedless() {
        return seedless;
    }

    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }

    @Override
    public void grow() {
        log("葡萄正在生长....");
    }

    @Override
    public void harvest() {
        log("葡萄正在被采摘....");
    }

    @Override
    public void plant() {
        log("葡萄正在被种下....");
    }

    static void log(String msg){
        System.out.println(msg);
    }
}
