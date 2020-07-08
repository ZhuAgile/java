package com.zmy.java.thread01.hashAndEquals;

import java.util.Objects;

public class Student {
    private String name;
    private String gender;
    private String age;
    private double height;
    private double weight;


    public Student() {
    }

    public Student(String name, String gender, String age, double height, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.getHeight(), getHeight()) == 0 && Double.compare(student.getWeight(), getWeight()) == 0 && Objects.equals(getName(), student.getName()) && Objects.equals(getGender(), student.getGender()) && Objects.equals(getAge(), student.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getAge(), getHeight(), getWeight());
    }

    public static void main(String[] args) {
        Student student1 = new Student("小明","","",185,75);
        Student student2 = new Student("小明","","",185,75);

        System.out.println("student1的内存地址为：" + student1);
        System.out.println("student2的内存地址为：" + student2);

        System.out.println(student1.equals(student2));
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
