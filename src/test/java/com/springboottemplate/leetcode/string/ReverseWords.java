package com.springboottemplate.leetcode.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author 唐涛
 * @description: 557. 反转字符串中的单词 III
 * @date 2021/12/9 10:20
 */
public class ReverseWords {


    @Test
    public void reverseWordsTest() {

        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    /**
     * 我自己的思路：
     * 根据空格，区分出单词，然后把每个单词反转，放在stringbuilder中
     */
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArr = s.split(" ");
        for (int i = 0; i < stringArr.length; i++) {
            String temp = stringArr[i];
           // stringBuilder.append(StringUtils.reverse(temp));//这行代码力扣没法编译换种写法
            stringBuilder.append(new StringBuilder().append(temp).reverse());
            if (i != stringArr.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
