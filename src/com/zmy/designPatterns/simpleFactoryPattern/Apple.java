package com.zmy.designPatterns.simpleFactoryPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 15:52
 * @description :
 **/
public class Apple implements Fruit{

    /** 树龄 */
    private int age;

    @Override
    public void grow() {
        log("苹果正在生长....");
    }

    @Override
    public void harvest() {
        log("苹果正在采摘....");
    }

    @Override
    public void plant() {
        log("苹果正在种植....");
    }

    public static void log(String msg){
        System.out.println(msg);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
