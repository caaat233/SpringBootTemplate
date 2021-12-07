package com.springboottemplate.Sort;

import java.util.Arrays;

import org.junit.Test;

public class XuanZeSort {
    /*
     *
　　简单选择排序是最简单直观的一种算法，基本思想为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
* 直到所有元素排完为止，简单选择排序是不稳定排序。

　　在算法实现时，每一趟确定最小元素的时候会通过不断地比较交换来使得首位置为当前最小，交换是个比较耗时的操作。
* 其实我们很容易发现，在还未完全确定当前最小元素之前，这些交换都是无意义的。我们可以通过设置一个变量min，
* 每一次比较仅存储较小元素的数组下标，当轮循环结束之后，那这个变量存储的就是当前最小元素的下标，此时再执行交换操作即可。代码实现很简单，一起来看下。
     *
     * 在最差情况下，也就是数组倒序的时候，交换次数为n-1次。综合下来，时间复杂度为O(n2)
     */

    @Test
    public void test1() {
        int[] arr = {5, 6, 2, 9, 8, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int[] arr = {9, 5, 6, 2, 9, 8, 7};
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        int[] arr = {9, 5, 6, 2, 9, 8, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }


}
