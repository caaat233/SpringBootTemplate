package com.springboottemplate.java8;

import com.google.common.collect.Lists;
import com.springboottemplate.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class lamdaTest {


    /**
     * lambda表达式用得最多的场合就是替代匿名内部类，而实现Runnable接口是匿名内部类的经典例子
     * <p>
     * <p>
     * <p>
     * Lambda 表达式的结构：
     * <p>
     * Lambda 表达式可以具有零个，一个或多个参数。
     * 可以显式声明参数的类型，也可以由编译器自动从上下文推断参数的类型。例如 (int a) 与刚才相同 (a)。
     * 参数用小括号括起来，用逗号分隔。例如 (a, b) 或 (int a, int b) 或 (String a, int b, float c)。
     * 空括号用于表示一组空的参数。例如 () -> 42。
     * 当有且仅有一个参数时，如果不显式指明类型，则不必使用小括号。例如 a -> return a*a。
     * Lambda 表达式的正文可以包含零条，一条或多条语句。
     * 如果 Lambda 表达式的正文只有一条语句，则大括号可不用写，且表达式的返回值类型要与匿名函数的返回类型相同。
     * 如果 Lambda 表达式的正文有一条以上的语句必须包含在大括号（代码块）中，且表达式的返回值类型要与匿名函数的返回类型相同。
     */
    @Test
    public void InnerClassTest() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();

         // 空括号用于表示一组空的参数。例如下面
        //上面代码的简写(   () -> 这个（）代表的是接口的参数，因为Runnable就一个接口，且这个接口没有参数，所以可以直接简写为（）      )
        new Thread(() -> System.out.println("It's a lambda function!")).start();


        Thread thread = new Thread(() -> {
            System.out.println("The old runable now is using!");
        });
        thread.start();


        /**
         * 集合比较
         */
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> finalNames = names.stream().collect(Collectors.toList());
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

