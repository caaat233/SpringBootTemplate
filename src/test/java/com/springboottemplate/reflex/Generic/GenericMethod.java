package com.springboottemplate.reflex.Generic;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author 唐涛
 * @description: 这个类，是声明各种泛型方法
 * @date 2021/4/28 10:57
 */
public class GenericMethod {


    /**
     * 根据集合的类型，返回集合 的第一个元素
     *
     * @param items
     * @param <T>
     * @return
     */
    private <T> T getListFirst(List<T> items) {
        return CollectionUtils.isNotEmpty(items) ? items.get(0) : null;
    }

    /**
     * 根据传入的对象，返回对应的泛型对象
     *
     * @param object
     * @param <T>
     * @return
     */
    private <T> T getObjectDto(T object) {

        return object;
    }

    /**
     * 返回泛型对象
     */
    private <T> T getObjectDto(String s) {
        return (T) s;
    }
}
