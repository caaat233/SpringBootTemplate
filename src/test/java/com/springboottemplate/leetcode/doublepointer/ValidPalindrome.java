package com.springboottemplate.leetcode.doublepointer;

import com.alibaba.druid.sql.visitor.functions.Left;
import org.junit.Test;

import java.util.Spliterator;

/**
 * @author 唐涛
 * @description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @date 2021/12/20 11:25
 * todo 我理解不到位
 */
public class ValidPalindrome {


    @Test
    public void validPalindromeTest() {
        System.out.println(validPalindrome("aba"));
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                if (left > chars.length / 2) {
                    return false;
                }
                if (validPalindrome(s.substring(left, right)) && validPalindrome(s.substring(left + 1, right + 1))) {
                    return true;
                }
            }
        }
        if (chars[left] == chars[right]) {
            return true;
        } else {
            return false;
        }
    }


//    public boolean validPalindrome(String s) {
//        int front = 0;
//        int end = s.length() - 1;
//        // < 符号，中间一个字符不影响回文与否
//        while (front < end) {
//            if (s.charAt(front) != s.charAt(end)) {
//                return validPalindromeHelper(s, front + 1, end) || validPalindromeHelper(s, front, end - 1);
//            }
//            front++;
//            end--;
//        }
//        return true;
//    }
//
//    public boolean validPalindromeHelper(String s, int front, int end) {
//        while (front < end) {
//            if (s.charAt(front) != s.charAt(end)) {
//                return false;
//            }
//            front++;
//            end--;
//        }
//        return true;
//    }
}