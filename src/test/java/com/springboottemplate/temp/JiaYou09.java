package com.springboottemplate.temp;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/10/29 17:45
 */
public class JiaYou09 {

    public static void main(String[] args) {
        JiaYou09 p1 = new JiaYou09("宋宇轩");
        p1.skkr();
        JiaYou09 p2 = new JiaYou09("宋宇轩", 19);
        p2.skkr();
        int i = 5;
        if (i > 2) {

            System.out.println(2);
        } else if (i > 3) {
            System.out.println(3);
        } else if (i > 4) {
            System.out.println(4);
        }

    }

    //你这个类声明了两个属性，这两个属性暂时没有值，赋值的方式有两种，1、构造器的方式，就是你下面的方式2、set方法赋值，后面你会学
    String name;
    int age;

    public JiaYou09(String name) {
        //this.name就是代表这个类的name,就是指的是JiaYou09你声明的name
        //name，是指的是JiaYou09(String name)这个构造器的参数，当你 new JiaYou09("宋宇轩");宋瑜轩这个值就会赋值给name，
        // 然后 这行代码this.name = name;，就是把name的值赋值给JiaYou09类下的name
        this.name = name;
    }

    public JiaYou09(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void skkr() {
        System.out.println("大家好，我叫" + name + "今年" + age + "岁");
    }
}