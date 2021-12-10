package com.springboottemplate.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @author 唐涛
 * @description: 344. 反转字符串
 * @date 2021/12/9 10:01
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {


    @Test
    public void reverseStringTest() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    /**
     * 解法很简单，第一个元素跟最后一个元素交换位置，根据i的下标确定要交换的数组小标即可
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int count = s.length / 2;
        for (int i = 0; i < count; i++) {
            int j = s.length - 1 - i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(ArrayUtils.toString(s));
    }


    @Test
    public void reverseStringATest() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseStringA(s);
    }


    /**
     * 不建议这样解题，还是要知道原理比较好
     *
     * @param s
     */
    public void reverseStringA(char[] s) {
        ArrayUtils.reverse(s);
        System.out.println(ArrayUtils.toString(s));
    }
}
