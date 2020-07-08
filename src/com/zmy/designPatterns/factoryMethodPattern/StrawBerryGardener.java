package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-18 23:13
 * @description :
 **/
public class StrawBerryGardener implements FruitGardener{
    @Override
    public Fruit fatory() {
        return new StrawBerry();
    }
}
