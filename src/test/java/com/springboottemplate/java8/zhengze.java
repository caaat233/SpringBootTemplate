package com.springboottemplate.java8;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: https://blog.csdn.net/qq_25835645/article/details/89315957
 * @date 2021/7/6 11:16
 */
public class zhengze {


    /**
     * demo
     * ^[0-9]+abc$
     * ^ 为匹配输入字符串的开始位置。
     * [0-9]+匹配多个数字， [0-9] 匹配单个数字，+ 匹配一个或者多个。
     * abc$匹配字母 abc 并以 abc 结尾，$ 为匹配输入字符串的结束位置。
     */
    @Test
    public void demo() {
        String str = "123abc";
        String patt1 = "^[0-9]+abc$";
        System.out.println(str.matches(patt1));
    }


    @Test
    public void lng() {
        //经度：整数部分为 -180.0～+180.0，小数位数最多保留6位，或者输fun入整数部分也可以
       // String patt1 = "^[\\-\\+]?(0?\\d{1,2}(\\.\\d{1,5})*|1[0-7]?\\d{1}(\\.\\d{1,5})*|180(\\.0{1,5})*)$";
        String patt1 = "^(\\-|\\+)?(((\\d|[1-9]\\d|1[0-7]\\d|0{1,3})\\.\\d{0,6})|(\\d|[1-9]\\d|1[0-7]\\d|0{1,3})|180\\.0{0,6}|180)$";
        System.out.println("180".matches(patt1));
        System.out.println("-180".matches(patt1));
        System.out.println("179.1234".matches(patt1));
        System.out.println("179.12345".matches(patt1));
        System.out.println("-179.123456".matches(patt1));
        System.out.println("-179.1234567".matches(patt1));
        System.out.println("a-179.123456".matches(patt1));
        System.out.println("-179.123a4".matches(patt1));

        //维度：整数部分为 -90.0～+90.0，小数位数最多保留6位，或者输入整数部分也可以，如【-90.000000,90.000000
        String lag="^[\\-\\+]?([0-8]?\\d{1}(\\.\\d{1,5})*|90(\\.0{1,5})*)$";

    }


}
