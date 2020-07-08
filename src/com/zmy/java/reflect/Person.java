package com.zmy.java.reflect;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.reflect
 * @projectName : project01
 * @date : 2020-05-27 14:21
 **/
public class Person {
    public static String id;
    private String name;
    private Integer age;

    public Person() {
        System.out.println("Person类的无参构造方法！");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static{
        System.out.println("静态代码块加载！");
    }
}
