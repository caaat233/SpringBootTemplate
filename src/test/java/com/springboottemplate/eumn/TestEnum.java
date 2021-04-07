package com.springboottemplate.eumn;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/3/1214:28
 */
public class TestEnum {



    @Test
    public void  test1(){
        String name = SeasonEnum.AUTUMN.getName();
        System.out.println(name);//秋
        System.out.println(SeasonEnum.AUTUMN.name());//AUTUMN
        System.out.println(SeasonEnum.SUMMER.getId());//2
    }
}
