package com.springboottemplate.leetcode;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 167. 两数之和 II - 输入有序数组
 * @date 2021/12/8 16:38
 * 20天算法刷题计划
 * https://leetcode-cn.com/study-plan/algorithms/?progress=a2r8oi5
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] returnArr = new int[2];
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] > target) {
                continue;
            }
            returnArr[0] = i + 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    returnArr[1] = j + 1;
                    return returnArr;
                }
            }
        }
        return returnArr;
    }


    /**
     * 最笨的做法，双重for循环，进行穷举，时间复杂度N^2
     */
    @Test
    public void twoSumA() {

        int[] numbers = {2, 25, 75};
        int target = 9;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > target) {
                continue;
            }
            int[] returnArr = new int[2];
            returnArr[0] = i + 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    returnArr[1] = j + 1;
                    System.out.println(numbers[i] + "   " + numbers[j]);
                    return;
                }

            }
        }

    }
}
