package com.zmy.designPatterns.simpleFactoryPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 15:51
 * @description :
 **/
public class Grape implements Fruit{

    /** 是否有籽 */
    private boolean seedless;

    @Override
    public void grow() {
        log("葡萄正在生长....");
    }

    @Override
    public void harvest() {
        log("葡萄正在采摘....");
    }

    @Override
    public void plant() {
        log("葡萄正在种植....");
    }

    public static void log(String msg){
        System.out.println(msg);
    }

    public boolean isSeedless() {
        return seedless;
    }

    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }
}
