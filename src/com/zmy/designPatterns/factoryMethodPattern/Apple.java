package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 21:52
 * @description :
 **/
public class Apple implements Fruit {

    // 苹果树树龄
    private int treeAge;

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }

    @Override
    public void grow() {
        log("苹果正在生长....");
    }

    @Override
    public void harvest() {
        log("苹果正在被采摘....");
    }

    @Override
    public void plant() {
        log("苹果正在被种下....");
    }

    static void log(String msg){
        System.out.println(msg);
    }
}
