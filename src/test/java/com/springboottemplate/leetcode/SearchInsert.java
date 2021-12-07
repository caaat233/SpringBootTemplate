package com.springboottemplate.leetcode;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: SearchInsert
 * @date 2021/12/6 15:02
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。(强迫你使用二分查找去，如果有序的话，使用遍历复杂度是n，很简单的)
 * 
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {//不能等于：需要明白二分查找的性质，如果没有找到对应的值，则右指针会指向最大小于target的值。
            int midlle = left + (right - left) / 2;//防止整型溢出
            if (target == nums[midlle]) {
                return midlle;
            } else if (target > nums[midlle]) {
                left = midlle + 1;
            } else {
                right = midlle - 1;
            }
        }
        //二分查找，如果这个数字找不到的话，left肯定大于right的。
        // 比如数组比如[1,3]，
        //情况1、 你要查找的是0， 那么right是1，下标是0。时候，这个时候left等于right.也是1。然后while接着走，right-1，下标就是-1了，所以0的位置就是right+1
        // 情况2、 你要查找的是5， 那么left是3，下标是1， right也是3的时候，还是找不到。然后while接着走，left就+1了，跳出循环了，这时候5的位置就是right+1

        return right + 1;
    }

    @Test
    public void searchInsertTest() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }
}
