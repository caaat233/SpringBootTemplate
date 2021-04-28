package com.springboottemplate.reflex.Generic;

/**
 * @author 唐涛
 * @description: 实现泛型接口，不指定类型：
 * @date 2021/4/28 11:07
 */
public class GenericInterfaceFuzzyImpl<T> implements GenericInterface<T> {
    @Override
    public T method() {
        return (T) null;
    }
}
