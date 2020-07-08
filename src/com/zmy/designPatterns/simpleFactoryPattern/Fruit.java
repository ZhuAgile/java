package com.zmy.designPatterns.simpleFactoryPattern;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 15:48
 * @description :
 **/
public interface Fruit {

    /*
     * 生长
     */
    void grow();

    /*
     * 收获
     */
    void harvest();

    /*
     * 种植
     */
    void plant();
}
