package com.zmy.java.object;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.java.object
 * @projectName : project01
 * @date : 2020-05-21 22:20
 **/
public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("小明",18);

        Student student1 = (Student) student.clone();
        System.out.println(student1);
    }
}
