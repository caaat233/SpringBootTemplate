package com.springboottemplate.leetcode.greed;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 55. 跳跃游戏
 * @date 2021/12/17 17:17
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {


    @Test
    public void canJump() {

        int[] num = {2, 3, 1, 1, 4};
        System.out.println(canJump(num));
        int[] numA = {3,2,1,0,4};
        System.out.println(canJump(numA));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

    }
}
