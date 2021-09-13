package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/9/8 17:21
 */
public class JavaRunProccessUtil {


    public JavaRunProccessUtil() {
        System.out.println("构造器中代码运行");
    }
    static {
        System.out.println("静态代码块运行");
    }


    {
        System.out.println("代码块运行");
    }

    static void out() {
        System.out.println("call out");
    }
}
