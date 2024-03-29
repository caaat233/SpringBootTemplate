package com.springboottemplate.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 唐涛
 * @description: 977. 有序数组的平方
 * @date 2021/12/7 10:06
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {


        return null;
    }














    @Test
    public void sortedSquaresMethodATest() {
        int[] nums = {-7, -3, 2, 3, 11};
        sortedSquaresMethodA(nums);
    }

    /**
     * 暴力解法，先平方，再排序,但是时间复杂度是n+log2^n
     *
     * @param nums
     * @return
     */
    public int[] sortedSquaresMethodA(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
