package com.zmy.designPatterns.factoryMethodPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.factoryMethodPattern
 * @projectName : project01
 * @date : 2020-06-15 21:49
 * @description :
 **/
public interface Fruit {

    /**
     * 生长
     */
    void grow();


    /**
     * 收割
     */
    void harvest();

    /**
     * 种植
     */
    void plant();
}
