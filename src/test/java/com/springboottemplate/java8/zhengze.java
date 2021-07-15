package com.springboottemplate.java8;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: TODO
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

}
