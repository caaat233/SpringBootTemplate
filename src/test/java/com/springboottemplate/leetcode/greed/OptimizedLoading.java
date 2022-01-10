package com.springboottemplate.leetcode.greed;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 唐涛
 * @description: 最优装载问题
 * @date 2021/12/17 16:56
 * https://blog.csdn.net/seagal890/article/details/90614064
 */

public class OptimizedLoading {
//    一条小船用来运输古董到河对岸。假设船的最大载重量为MAXWEIGHT，每件古董的重量为w_i，怎么能够装载最多数量的古董到船上呢？
//
//    样例数据：
//
//    MAXWEIGHT 为 30
//
//    给定8个古董，重量分别为：[4, 10, 7, 11, 3, 5, 14, 2]


    @Test
    public void maxLoadingTest() {

        int ANSWER = 0; // 记录已装载的古董个数
        int[] weight = {4, 10, 7, 11, 3, 5, 14, 2};
        ANSWER = maxLoading(weight);
        System.out.println("能装入的古董最大数量为: " + ANSWER);
    }


    public int maxLoading(int[] arr) {
        Arrays.sort(arr);
        int weight = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (weight <= 30) {
                if (weight + arr[i] > 30) {
                    return count;
                }
                weight += arr[i];
                count++;
            }

        }

        return 0;
    }
}
