package com.springboottemplate.reflex.Generic;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/28 11:06
 */

/**
 *声明泛型接口，可以有两种实现
 * 1、实现泛型接口，不指定类型：
 * 2、实现泛型接口，指定类型：
 */
public interface GenericInterface<T>  {
    public T method();
}
