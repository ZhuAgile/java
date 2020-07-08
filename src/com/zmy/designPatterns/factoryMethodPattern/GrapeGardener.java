package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 22:00
 * @description :
 **/
public class GrapeGardener implements FruitGardener {
    @Override
    public Fruit fatory() {
        return new Grape();
    }
}
