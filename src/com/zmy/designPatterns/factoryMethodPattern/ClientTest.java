package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 22:01
 * @description :
 *
 **/
public class ClientTest {
    public static void main(String[] args) {
        FruitGardener fruitGardener = new AppleGardener();
        Fruit apple = (Apple) fruitGardener.fatory();

        apple.plant();
        apple.grow();
        apple.harvest();
        System.out.println("---------------------------------");

        FruitGardener fruitGardener1 = new StrawBerryGardener();
        Fruit strawBerry = (StrawBerry) fruitGardener1.fatory();

        strawBerry.plant();
        strawBerry.grow();
        strawBerry.harvest();
        System.out.println("---------------------------------");

        FruitGardener fruitGardener2 = new GrapeGardener();
        Fruit grape = (Grape) fruitGardener2.fatory();

        grape.plant();
        grape.grow();
        grape.harvest();
    }
}
