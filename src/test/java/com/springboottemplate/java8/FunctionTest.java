package com.springboottemplate.java8;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

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


    @Test
    public void test() {

        testFunction("张三", (string) -> {
            System.out.println("*******2*********");
            List list = modifyString(string);
            return list;
        });
    }

    public void testFunction(String name, Function<String, List<T>> getList) {
        System.out.println("*******1*********");
        /**
         * 1、执行  getList.apply(name)
         * 相当于
         *  执行下面的内容
         *       (string) -> {
         *             List list = modifyString(string);
         *             return list;
         *         });
         *  2、 为什么string变成了张三
         *   因为执行 getList.apply(name)等于执行
         *     执行下面的内容
         *       (string) -> {
         *             List list = modifyString(string);
         *             return list;
         *         });
         *   那么name就传递给 (string)了
         */
        System.out.println(getList.apply(name));
    }


    public List modifyString(String a) {
        System.out.println("*******3*********");
        ArrayList objects = new ArrayList<>();
        objects.add("lisi");
        objects.add(a);
        return objects;
    }
}
