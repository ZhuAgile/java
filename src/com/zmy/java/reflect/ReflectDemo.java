package com.zmy.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.reflect
 * @projectName : project01
 * @date : 2020-05-27 14:23
 **/
public class ReflectDemo {
    public static void main(String[] args) throws Exception {

        Class clazz1 = Class.forName("com.zmy.java.reflect.Person");
        Person p1 = (Person)clazz1.newInstance();


    }
}
