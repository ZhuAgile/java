package com.zmy.designPatterns.singletonPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.singletonPattern
 * @projectName : project01
 * @date : 2020-06-18 22:45
 * @description :
 * 饿汉式单例模式
 **/
public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();

    public EagerSingleton() {
        System.out.println("饿汉式单例模式无参构造方法");
    }

    public static EagerSingleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        getInstance();
        getInstance();
        getInstance();
    }
}
