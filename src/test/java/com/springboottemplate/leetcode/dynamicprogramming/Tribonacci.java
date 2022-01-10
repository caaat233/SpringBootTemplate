package com.springboottemplate.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 1137. 第 N 个泰波那契数
 * @date 2021/12/14 19:35
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Tribonacci {
    //
//    泰波那契序列Tn定义如下：
//
//    T0 = 0, T1 = 1, T2 = 1,T3 = 2,,T4 = 4 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//    给你整数n，请返回第 n 个泰波那契数Tn 的值。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    @Test
    public void Test() {

        System.out.println(tribonacci(25));
    }


    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        //直接用递归的话会超时，给定的通项公式可以进一步推导
        //T(n+3) = T(n+2) + T(n+1) +T(n+0)， T(n+4) = T(n+3) + T(n+2) + T(n+1)， 两者相减 T(n+4) - T(n+3) = T(n+3) - T(n)， 所以T(n) = 2T(n-1) - T(n+4)
        // return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        return 2 * tribonacci(n - 1) - tribonacci(n - 4);
    }
}
