package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 21:58
 * @description :
 **/
public class AppleGardener implements FruitGardener {
    @Override
    public Fruit fatory() {
        return new Apple();
    }
}
