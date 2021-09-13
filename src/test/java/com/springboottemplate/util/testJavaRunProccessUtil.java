package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/9/8 17:23
 */
public class testJavaRunProccessUtil {


    public static void main(String[] args) {

        //静态代码块只会执行一次
        /**
         * 总结：直接调用工具类的静态方法，会先执行静态代码块、再执行方法中的代码，不执行构造器、普通代码块中的代码
         */
        JavaRunProccessUtil.out();
        System.out.println("****************************");
        JavaRunProccessUtil.out();
        System.out.println("****************************");
        //普通代码块每次调用都会执行代码块
        /**
         * 总结：new 对象调用方法，会执行静态代码块、代码块、构造器、方法中代码的顺序
         */
        new JavaRunProccessUtil().out();
        System.out.println("****************************");
        new JavaRunProccessUtil().out();
    }
}
