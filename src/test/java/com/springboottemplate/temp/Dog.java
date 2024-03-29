package com.springboottemplate.temp;

import com.alibaba.fastjson.JSON;

/**
 * @author 唐涛
 * @description: 多态, 子类初始化之前，要先初始化父类，所以子类有的构造器，父类也要有
 * @date 2021/11/8 11:06
 */
public class Dog extends Animal {

    String dogName = "dogName";

    public Dog(String name, int id) {
        super(name, id);
    }

    public Dog() {
    }

    public void eat() {
        System.out.println("狗正在吃饭");

    }

    public void sleeep() {
        System.out.println("狗正在睡觉");
    }


    public void run() {
        System.out.println("狗正在跑");
    }


    public static void main(String[] args) {

        Animal animal = new Dog("小狗", 1);//上转型
        animal.eat();
        animal.sleeep();
        System.out.println(animal.id + " " );
        System.out.println(JSON.toJSONString(animal));
        //下转型1
        Dog dog = (Dog) animal;//这里转换不会报错，因为animal本身指向的就是Dog
        dog.eat();
        dog.sleeep();
       // dog.name; name是父类私有的，获取不到，但是可以通过get方法
        System.out.println(dog.getName());
        //下转型2
        Dog dog2 = (Dog) new Animal();//这里会报错，类型转换异常
        dog.eat();
        dog.sleeep();
        /**
         * 原因
         * 1、上转型，一定能成功，
         *     原因：子类转换成父类，天经地义
         * 2、下转型只有代码下转型1的代码才是对的。
         *       原因：父类其实是不能直接转化成子类的。比如下转型2的代码就是错的 Dog dog2=(Dog)new Animal()
         *             所谓的父类转子类：必须先是把子类对象指向了父类，然后才能把父类引用强转子类对象，比如上面的下转型1的代码
         *
         *
         */


    }


}
