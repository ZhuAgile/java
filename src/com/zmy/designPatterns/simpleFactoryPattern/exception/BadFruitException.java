package com.zmy.designPatterns.simpleFactoryPattern.exception;

import java.beans.ExceptionListener;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.designPatterns.simpleFactoryPattern.exception
 * @projectName : project01
 * @date : 2020-06-14 16:11
 * @description :
 **/
public class BadFruitException extends Exception {
    public BadFruitException(String msg) {
        super(msg);
    }
}
