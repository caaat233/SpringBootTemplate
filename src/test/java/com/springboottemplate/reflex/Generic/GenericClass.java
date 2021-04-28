package com.springboottemplate.reflex.Generic;

/**
 * @author 唐涛
 * @description: 泛型类
 * @date 2021/4/28 11:02
 */

/**
 * 常用的通配符为： T，E，K，V，？
 *
 * ？ 表示不确定的 java 类型
 * T (type) 表示具体的一个 java 类型
 * K V (key value) 分别代表 java 键值中的 Key Value
 * E (element) 代表 Element
 */

/**
 * 再实例化泛型类的时候，必须执行类的类型，同时把类型传递给对应属性
 * @param <T>
 */
public class GenericClass<T> {

    public T  objcet;


    public T getObjcet() {
        return objcet;
    }

    public void setObjcet(T objcet) {
        this.objcet = objcet;
    }
}
