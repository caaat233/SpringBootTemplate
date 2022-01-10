package com.springboottemplate.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 509. 斐波那契数
 * @date 2021/12/14 19:29
 * <p>
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Fib {


    @Test
    public void fibTest() {
        System.out.println(fib(5));

    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }

    /**
     * 斐波那契数列并不是严格意义上的动态规划，因为它不涉及到求最值，用这个例子旨在说明重叠子问题与状态转移方程
     * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1)= 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */

    // 递归法(21ms,代码少，效率低)
    public int fibA(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    // 数组法(1ms,要操作数组,效率比操作整型低一点)
    public int fibB(int N) {
        assert N > -1;
        if (N == 0 || N == 1) {
            return N;
        }
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[N];
    }

    // 替换法(0ms,效率最高,内存消耗都差不多)
    public int fibC(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int x = 0, y = 1, z = 1, i = 0, end = N - 2;
        while (i <= end) {
            z = x + y;
            x = y;
            y = z;
            i++;
        }
        return z;
    }

}
