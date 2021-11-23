package com.springboottemplate.temp;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/11/8 10:41
 */
public class Animal {

    private String name;
    private int id;

    private int age;

    /**
     * 无参构造器，用来new对象的
     */
    public Animal() {
    }

    /**
     * 有参构造器
     *
     * @param name
     * @param id
     */
    public Animal(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public Animal(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void eat() {
        System.out.println("动物正在吃饭");

    }

    public void run() {
        System.out.println("动物正在跑");
    }

    public void sleeep() {
        System.out.println(name + "动物正在睡觉");
    }

    public void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + ".");
    }
}
