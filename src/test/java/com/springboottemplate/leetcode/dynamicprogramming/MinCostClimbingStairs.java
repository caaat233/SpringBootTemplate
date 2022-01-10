package com.springboottemplate.leetcode.dynamicprogramming;

import org.apache.poi.ss.formula.functions.Count;
import org.junit.Test;

/**
 * @author 唐涛
 * @description: 746. 使用最小花费爬楼梯
 * @date 2021/12/15 10:56
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * <p>
 * <p>
 * <p>
 * 这道题不太好懂的是题意。
 * <p>
 * 每一个位置都有 2 个阶梯，1 个阶梯上一层楼，另 1 个阶梯上两层楼；
 * 上两个阶梯的体力值耗费是一样的，但是在不同位置消耗的体力值是不一样的；
 * 楼层顶部在数组之外。如果数组长度为 len，那么楼顶就在下标为 len，注意 dp 数组开 len + 1 个空间。
 * <p>
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/dong-tai-gui-hua-by-liweiwei1419-3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    /**
     * 状态转移方程定义 动态规划中本阶段的状态往往是上一阶段状态和上一阶段决策的结果。
     * 若给定了第K阶段的状态Sk以及决策uk(Sk),则第K+1阶段的状态Sk+1也就完全确定。 ... 这种用函数表示前后阶段关系的方程，称为状态转移方程。
     */

    @Test
    public void 测试() {

        int[] count = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] count1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(count1));
    }

    //todo  ,我不太懂的。
    public int minCostClimbingStairs(int[] cost) {
        //楼梯顶的层数为cost.length+1，所以新数组为dp[len+1]
        //第一层和第二层楼梯不消耗体力，所以dp[0]=dp[1]=0
        //上楼梯需要花费的体力为当前已花费的体力+即将花费的体力,且有两种上楼梯的方式，所以上楼梯的花费也有两种情况：
        //第i层台阶的花费为第i-1个台阶的花费+登上第i-1个台阶的累计花费;
        //第i层台阶的花费为第i-2个台阶的花费+登上第i-2个台阶的累计花费;
        int len = cost.length;
        if (len < 2) return 0;
        int dp[] = new int[len + 1];
        dp[0] = dp[1] = 0;
        int i = 2;
        while (i <= len) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            i++;
        }
        return dp[len];

    }


}
