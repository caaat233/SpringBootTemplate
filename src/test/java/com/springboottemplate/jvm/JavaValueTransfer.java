package com.springboottemplate.jvm;

/**
 * @author 唐涛
 * @description: java 值传递、引用传递的问题
 * @date 2021/9/24 14:24
 */

/**
 * String表现为值传递，主要是因为这个玩意儿是不可变的！如何理解不可变？我们一般说的改变一个String变量，
 * 其实并不是改变的这个String本身，而是用一个新的String去替换掉原来的，原来的String本身并没有变。
 */
public class JavaValueTransfer {


    public static void main(String[] args) {
        String name = new String("张三");
        System.out.println(name);
    }


    public void modifyString(String value) {
        value = "lisi";
    }

}
