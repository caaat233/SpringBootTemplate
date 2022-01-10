package com.springboottemplate.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 70. 爬楼梯（动态规划）
 * @date 2021/12/15 9:58
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {


    @Test
    public void 测试() {
        System.out.println(climbStairsA(10));
        System.out.println(climbStairsB(10));
    }

    /**
     * 第n个台阶只能从第n-1或者n-2个上来。到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。
     *
     * @param n
     * @return
     */
    public int climbStairsB(int n) {
        if (n == 1 || n == 2) {
            return n;

        }
        int previousTwo = 1;//previousTwo 表示第n-2个台阶的走法，b表示第n-1个台阶的走法,传统迭代
        int previousOne = 2;//previousOne 表示第n-2个台阶的走法，b表示第n-1个台阶的走法,传统迭代
        int count = 0;
        for (int i = 3; i <= n; i++) {
            //累加结果
            count = previousOne + previousTwo;        //累加结果
            previousTwo = previousOne;////下次迭代的第n-2个台阶的走法等于上次迭代n-1个台阶的走法
            previousOne = count;////下次迭代的第n-1个台阶的走法等于上次迭代的第n个台阶走法
        }
        return count;
    }

    /**
     * 使用递归的方法会超时
     *
     * @param n
     * @return
     */
    public int climbStairsA(int n) {
        if (n == 1) {
            return 1;

        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }

        return climbStairsA(n - 1) + climbStairsA(n - 2);
    }
}
