package com.springboottemplate.template.transaction;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/21 16:36
 */

/**
 * @FunctionalInterface
 * 通过JDK8源码javadoc，可以知道这个注解有以下特点：
 * <p>
 * 1、该注解只能标记在"有且仅有一个抽象方法"的接口上。
 * <p>
 * 2、JDK8接口中的静态方法和默认方法，都不算是抽象方法。
 * <p>
 * 3、接口默认继承java.lang.Object，所以如果接口显示声明覆盖了Object中方法，那么也不算抽象方法。
 * <p>
 * 4、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。
 * ————————————————
 * 版权声明：本文为CSDN博主「aitangyong」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/aitangyong/article/details/54137067
 */
@FunctionalInterface
public interface SpringBootTemplateAction<T> {
    //interface一定是abstract的，所以是否加abstract没什么区别。
    T execute();
}
