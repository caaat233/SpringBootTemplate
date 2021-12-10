package com.springboottemplate.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 唐涛
 * @description: 283. 移动零
 * @date 2021/12/8 15:39
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {


    @Test
    public void moveZeroesTest() {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    /**
     * 我自己的思路是.
     * 思路1
     * 把数组转换成链表，然后删除为0的元素，在链表最后补齐。但是不符合规则，不是在原来数组上操作了
     *
     * @param nums
     */
    public void moveZeroesA(int[] nums) {


    }

    /**
     * 思路2；类似于冒泡排序，如果指针的left元素是0，就与指针的right位置的元素素交换位置，如果下个元素是0，依然是第一个为0的元素与别的元素交换。
     * 例如1 2 0 3 0 4
     * 第1次： left=1,right=2（指的是数据的值）,1 2都不是0，所以都加1     这时候数组是120304，
     * 第2次： left=2,right=0,  left不是0，所以不交换位置，还是120304，
     * 第3次： left=0,right=3,  这时候left是0，与right交换位置，     数组交换后为    123004
     * 第4次： left=0,right=0，这时候，因为都是0，不交换位置，只有right加1   数组还是    123004
     * 第5次： left=0[下标是3], right=4，这时候， 0与4 交互位置，只有right与left都加1
     * <p>
     * * @param nums
     */
    @Test
    public void moveZeroesB() {
        int[] nums = {0, 1, 0, 3, 12};
        int left = 0;//
        int right = 1;
        while (right < nums.length && left < nums.length) {
            if (nums[left] == 0 && nums[right] == 0) {
                right += 1;// left=0,right=0，这时候，因为都是0，不交换位置，只有right加1
            } else if (nums[left] != 0) {
                left += 1;
                right += 1;
            } else {//这种场景，其实就是right是0的时候。代码简写，就是标准答案moveZeroes这个方法
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
