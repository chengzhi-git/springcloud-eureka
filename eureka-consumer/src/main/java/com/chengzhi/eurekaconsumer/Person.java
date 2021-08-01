package com.chengzhi.eurekaconsumer;

/**
 * @Author:chengzhi
 * @Date:2021/8/1 22:34
 * @Description
 */
public class Person {
    private String name;
    private int age;

    //保持无参构造
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
