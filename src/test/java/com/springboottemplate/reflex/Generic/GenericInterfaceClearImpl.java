package com.springboottemplate.reflex.Generic;

/**
 * @author 唐涛
 * @description: 实现泛型接口，指定类型：
 * @date 2021/4/28 11:11
 */
public class GenericInterfaceClearImpl<T> implements GenericInterface<String> {
    @Override
    public String method() {
        return "String";
    }
}
