package com.springboottemplate.java8;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.formula.functions.Value;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/6/3 10:24
 */

public class FunctionTest {

    public static void main(String[] args) {


    }


    /**
     * function在同一个方法中的使用
     */
    @Test
    public void test() {

        Function<String, List<String>> function1 = new Function<String, List<String>>() {
            @Override
            public List<String> apply(String s) {
                System.out.println("********1**********");
                System.out.println(s);
                return null;
            }
        };

        //这是上面代码的简写
        Function<String, List<String>> function3 = (value) -> {
            System.out.println("********2**********");
            System.out.println(value);
            return null;
        };

        //这是上面代码的简写,yige参数，括号可以省略
        Function<String, List<String>> function2 = value -> {
            System.out.println("********2**********");
            System.out.println(value);
            return null;
        };


        //只有调用了apply,上面的function代码才会执行,其他的不要考虑那么多
        function1.apply("zhangsan");
        function2.apply("lisi");
    }


    /**
     * 下面两个方法表示function在不同方法中的应用，不推荐这样使用，跟放在同一个方法中差不多，而且代码理解起来费劲，吃力不讨好
     * <p>
     * <p>
     * <p>
     * String 传入的是name
     * <p>
     * nameList 指的是name的集合
     *
     * @param nameList
     */
    public List doSomeing(Function<String, List<T>> nameList) {
        System.out.println("*****第一步****");
        String name = "zhangsan";
        if (true) {
            name = "zhangsan";
        }
        System.out.println("*****第二步****");
        List<T> dataList = nameList.apply(name);
        System.out.println("*****第四步****");
        //执行 nameList.apply(name);，相当于直接执行下面代码，
        return dataList;
    }


    @Test
    public void callDoSomeing() {
        List list = doSomeing(new Function<String, List<T>>() {
            @Override
            public List<T> apply(String s) {
                System.out.println("*****第三步****");
                List objects = new ArrayList<>();
                objects.add("lisi");
                objects.add(s);
                return objects;
            }

        });
        System.out.println("*****第五步****");
        System.out.println(list.toString());
    }

}


