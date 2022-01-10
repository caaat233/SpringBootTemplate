package com.springboottemplate.leetcode.search;

import com.alibaba.druid.sql.visitor.functions.Right;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 唐涛
 * @description: 3. 无重复字符的最长子串
 * @date 2021/12/2 16:24
 * <p>
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。(滑动窗口算法可以用以解决数组/字符串的子元素问题，
 * 它可以将嵌套的循环问题，转换为单循环问题，降低时间复杂度。)
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 滑动窗口算法(Sliding Window)
 * https://www.jianshu.com/p/e6622df3c377
 */
public class lengthOfLongestSubstring {


    @Test
    public void lengthOfLongestSubstringTest() {

        String s = "1233";
        System.out.println(lengthOfLongestSubstring(s));

    }

    /**
     * 滑块算法，这种算法只能得到子串的长度，但是子串的值打印的是不对的
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {

        LinkedList<Character> l = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            l.add(c);

            long count = l.stream().distinct().count();
            if (l.size() != count) {
                l.removeFirst();
            }
        }
        System.out.println(l);
        return l.size();
    }


    @Test
    public void testSubString() {
        String s = "12345";
        System.out.println(s.substring(4, 5));
    }


    @Test
    public void 自己练习() {
        String s = "abcabcbb";


        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            linkedList.add(c);
            //判断这个元素是否重复
            long count = linkedList.stream().distinct().count();//去重
            if (count != linkedList.size()) {
                linkedList.removeFirst();
            }
        }
        System.out.println(linkedList.size());

    }


}
