package com.springboottemplate.leetcode.search;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: BinarySearch(二分查找)
 * @date 2021/12/6 14:10
 * <p>
 * /**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearch {

    /**
     * 主要是二分查找.通过全部测试用例
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <=right) {
            int midlle = (left + right) / 2;
            if (target == nums[midlle]) {
//                System.out.println("下标："+midlle);
//                System.out.println(nums[midlle]);
                return midlle;
            } else if (target > nums[midlle]) {
                left = midlle + 1;
            } else {
                right = midlle - 1;
            }
        }
        return -1;
    }

    @Test
    public void searchTest() {
        int[] nums = {5};
        System.out.println( search(nums, 5));
    }

}
