package com.zmy.designPatterns.simpleFactoryPattern;

import com.zmy.designPatterns.simpleFactoryPattern.exception.BadFruitException;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 16:06
 * @description :
 **/
public class FruitGardener {

    /**
     * 静态工厂方法
     * @param fruitName
     */
    public static Fruit factory(String fruitName) throws BadFruitException {
        if (fruitName.equals("apple")) {
            return new Apple();
        } else if (fruitName.equals("grape")) {
            return new Grape();
        } else if (fruitName.equals("strawBerry")) {
            return new StrawBerry();
        } else {
                throw new BadFruitException("没有该水果！");
        }

    }
}
