package com.springboottemplate.leetcode.dynamicprogramming;

import org.junit.Test;

import javax.validation.constraints.Max;

/**
 * @author 唐涛
 * @description: 198. 打家劫舍
 * @date 2021/12/16 17:13
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {
//    输入：[1,8,6,9,3,1]


    @Test
    public void 测试() {

        int[] arr = {1, 3, 1};
        System.out.println(rob(arr));


    }


    /**
     * 动态规划。当前位置的最大金额，等于前一个位置的金额，或者前前位置金额加上当前位置金额。dp[i]=max(dp[i-1], dp[i-2]+nums[i])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //上面是数据为特殊情况的时候，
        int di = 0;
        // 从下标等于2开始，也就是从6开始，
        for (int i = 2; i < nums.length; i++) {
            if (di != 0) {
                nums[i - 1] = di;
            }
            //方程推导过程，我们只管取每次最优解即可。
            //[1,8,6,9,3,1]
            //我们开始偷1，然后偷6结果是7.那不如直接偷8。这才是最优，每次取最优结果即可算出能偷的最大值
            //所以状态方程就是max(a[i-2]+a[i],a[i-1])
            di = Math.max(nums[i - 1], nums[i - 2] + nums[i]);

        }
        return di;
    }
}
