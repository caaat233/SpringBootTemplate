package com.springboottemplate.leetcode.doublepointer;

/**
 * @author 唐涛
 * @description: 88. 合并两个有序数组
 * @date 2021/12/20 18:34
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge {
    /**
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * 题目描述：把归并结果存到第一个数组上。
     */


    /**
     * 方法1，用num2的元素替换nums1为0的元素，然后直接排序
     */
    public void mergeA(int[] nums1, int m, int[] nums2, int n) {


    }

    /**
     * 方法2，把num1与num2 当成两个队列，每次取他们的最小值。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {lo
        m--;
        n--;
        while (n >= 0) {
            //m >= 0是避免 nums1={0}的情况
            if (m >= 0 && nums1[m] > nums2[n]) {
                //nums1 > nums2,则把nums1[m]放到nums1数组后面,m再自减一
                nums1[(m + n + 1)] = nums1[m--];
            } else {
                //nums2 >= nums1,则把nums2[n]放到nums1数组后面,n再自减一
                nums1[(m + n + 1)] = nums2[n--];
            }
        }
    }

}
