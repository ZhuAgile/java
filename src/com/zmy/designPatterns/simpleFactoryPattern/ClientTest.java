package com.zmy.designPatterns.simpleFactoryPattern;

import com.zmy.designPatterns.simpleFactoryPattern.exception.BadFruitException;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern
 * @projectName : project01
 * @date : 2020-06-14 16:17
 * @description :
 **/
public class ClientTest {
    public static void main(String[] args) {
        try {

            FruitGardener.factory("apple").plant();
            FruitGardener.factory("grape").plant();
            FruitGardener.factory("strawBerry").plant();

        } catch (BadFruitException e) {
            e.printStackTrace();
        }

    }
}
