package com.springboottemplate.string;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/28 14:04
 */
public class TestInt {



    @Test
    public void switchtest11() {
    }


    public Boolean switchtest() {
        switch ("GRAY_SYSTEM") {
            case "OLD_SYSTEM":
                return false;
            case "NEW_SYSTEM":
                return true;
            case "":
                //灰度期间，返回null进入下面的判断
                return null;
            default:
                return false;
        }
    }
    /**
     * Integer 对象比较
     */
    @Test
    public void test() {
        int i = 100;
        int j = 100;
        int m = 200;
        int n = 200;
        System.out.println(i == j);//true
        System.out.println(m == n);//true
        System.out.println("***************************************");
        Integer integer1 = new Integer("100");
        Integer integer2 = new Integer("100");
        Integer integer3 = new Integer("200");
        Integer integer4 = new Integer("200");
        System.out.println(integer1 == integer2);//falsef
        System.out.println(integer3 == integer4);//false
        System.out.println(integer3.equals(integer4));//true
        System.out.println(i==integer1);//true
        System.out.println("***************************************");
        Integer integer5 = 100;
        Integer integer6 = 100;
        Integer integer7 = 200;
        Integer integer8 = 200;
        System.out.println(integer5 == integer1);//false
        System.out.println(integer6 == integer5);//true
        System.out.println(integer7==integer8);//false
    }
}
