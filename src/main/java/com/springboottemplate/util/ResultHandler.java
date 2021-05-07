package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description:定义接口， 通过body判断执行哪一个
 * @date 2021/5/7 15:59
 */
public interface ResultHandler {
    /**
     * 优先级
     * @return
     */
    int value();

    String execute(String body);

    /**
     * Java8新增了default关键字，可以使接口有自己的默认的实现类，而且还不影响接口的实现类。
     * @param body
     * @return
     */
    default boolean accept(String body) {
        return true;
    }
}
