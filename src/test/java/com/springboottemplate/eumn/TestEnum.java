package com.springboottemplate.eumn;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/3/1214:28
 */
public class TestEnum {

    /**
     * 测试AbilityNameEnum枚举类，根据枚举的key得到枚举值
     */
    @Test
    public void  AbilityNameEnum(){
        // 根据类型获取描述
        String desc = AbilityNameEnum.getValue("bmw");
        System.out.println("根据类型获取描述：" + desc);
        String desc1 = AbilityNameEnum.getValue("Forward FM");
        System.out.println("根据类型获取描述：" + desc1);
        String desc2 = AbilityNameEnum.getValue("Forward LM");
        System.out.println("根据类型获取描述：" + desc2);


    }
    /**
     * 测试CarTypeEnum枚举类，根据枚举的key得到枚举值
     */
    @Test
    public void  test3(){
        // 根据类型获取描述
        String desc = CarTypeEnum.getValue("bmw");
        System.out.println("根据类型获取描述：" + desc);
        // 根据描述获取类型
        String type = CarTypeEnum.getType("宝马");
        System.out.println("根据描述获取类型：" + type);

    }
    /**
     * 测试OrderEum枚举类
     */
    @Test
    public void  test2(){
        System.out.println(OrderEum.READY);//READY
        System.out.println(OrderEum.READY.name());//READY
        System.out.println(OrderEum.READY.getName());//ready
       //枚举类如果判断是否相等
        String name="ready";
        String NAME="READY";
        System.out.println(NAME==OrderEum.READY.getName());//false
        System.out.println(name.equals(OrderEum.READY.getName()));//true

    }
    /**
     * 测试SeasonEnum枚举类
     */
    @Test
    public void  test1(){
        System.out.println(SeasonEnum.SPRING);//SPRING
        System.out.println(SeasonEnum.SPRING.name());//SPRING
        System.out.println(SeasonEnum.SPRING.getId());//1
        System.out.println(SeasonEnum.SPRING.getName());//春
        System.out.println(SeasonEnum.SPRING.getClass());//class com.springboottemplate.eumn.SeasonEnum
        System.out.println(SeasonEnum.SPRING.name().getClass());//class java.lang.String

    }
}
