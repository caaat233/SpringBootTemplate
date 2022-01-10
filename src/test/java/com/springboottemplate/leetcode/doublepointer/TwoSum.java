package com.springboottemplate.leetcode.doublepointer;

/**
 * @author 唐涛
 * @description: 两数之和 II - 输入有序数组,解法：双指针
 * @date 2021/12/20 10:42
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
 */
public class TwoSum {


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            if (left >= right) {
                return null;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{
                        left + 1, right + 1
                };
            }
        }

    }
}
