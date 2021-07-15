package com.springboottemplate.java8;

import com.google.common.collect.Lists;
import com.springboottemplate.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class lamdaTest {


    /**
     * lambda表达式用得最多的场合就是替代匿名内部类，而实现Runnable接口是匿名内部类的经典例子
     */
    @Test
    public void InnerClassTest() {
        new Thread(() -> System.out.println("It's a lambda function!")).start();

        /**
         *等效于
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();

        /**
         * 集合比较
         */
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> finalNames=names.stream().collect(Collectors.toList());
        int i = 1;
        boolean success = false;
        AtomicBoolean needSendMsg = new AtomicBoolean(false);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //因为我这是lamda的写法，所以局部变量i不用声明为final依然能访问，但是i是不能修改的，他是隐式的final类型
                System.out.println(finalNames);
                System.out.println(i);
                //success==true;//不能修改,想修改，必须声明为包装类
                //lamada表达式，不能修改外部得基础类型，是因为基础类型是值传递，lamadab表达式里面存得是副本，所以没法改
                //为什么包装类，可以改，我们只能改变包装类的值，但是不能改变包装类引用指向得地址
                needSendMsg.set(true);
                finalNames.add("李四");
                return b.compareTo(a);
            }
        });
        //lamda简写
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names.toString());
    }


}

