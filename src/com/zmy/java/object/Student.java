package com.zmy.java.object;

import java.io.*;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.object
 * @projectName : project01
 * @description : 五种创建对象的方式
 * @date : 2020-05-21 14:41
 **/

public class Student implements Cloneable{
    private String name;
    private Integer age;

    public Student() {
        System.out.println("无参构造方法！");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造方法！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
