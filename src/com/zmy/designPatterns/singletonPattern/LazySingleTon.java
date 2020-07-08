package com.zmy.designPatterns.singletonPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.singletonPattern
 * @projectName : project01
 * @date : 2020-06-18 22:46
 * @description :
 * 懒汉式单例模式
 **/
public class LazySingleTon {
    private static volatile LazySingleTon singleTon = null;

    public LazySingleTon() {
        System.out.println("懒汉式单例模式无参构造方法");
    }

    public static LazySingleTon getInstance(){
        if (singleTon == null) {
            synchronized (LazySingleTon.class){
                if (singleTon == null) {
                    singleTon = new LazySingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        getInstance();
        getInstance();
        getInstance();
    }
}
