package com.springboottemplate.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 唐涛
 * @description: 189. 轮转数组
 * @date 2021/12/7 14:14
 * 给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate {


    /**
     * 优雅解法
     *
     * @param nums
     * @param k    思路：开辟额外的数组存放原数组（复制原数组）news，作为结果的nums数组中的 nums[i]，在news数组中找到对应的数组元素即 news[(i+k)%n] 做交换，一一映射。
     *             时间复杂度分析：O(n)
     *             空间复杂度分析：O(n)
     *             作者：wJBMvoYDFU
     *             链接：https://leetcode-cn.com/problems/rotate-array/solution/189-xuan-zhuan-shu-zu-fu-2chong-jie-fa-b-rkrd/
     *             来源：力扣（LeetCode）
     *             著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        int[] news = Arrays.copyOf(nums, n);

        for (int i = 0; i < n; i++) {
            //除n,代表需要位移的数
            nums[(i + k) % n] = news[i];
        }
    }


    @Test
    public void rotateATest() {

        int[] nums = {-1, -100, 3, 99};
        rotateA(nums, 2);

    }

    /**
     * 利用链表的方式实现，时间复杂度比较高，而且空间复杂度是K。不是1
     *
     * @param nums
     * @param k
     */
    public void rotateA(int[] nums, int k) {

        LinkedList<Integer> linkedList = new LinkedList();
        LinkedList<Integer> tempList = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            linkedList.add(nums[i]);//添加节点
        }
        for (int i = 1; i <= k; i++) {
            tempList.addFirst(linkedList.getLast());
            linkedList.removeLast();
        }
        tempList.addAll(linkedList);
        int[] returnNum = new int[tempList.size()];


        for (int i = 0; i < returnNum.length; i++) {
            returnNum[i] = tempList.get(i);
        }
        nums = returnNum;//赋值给形参，不然letcoode提交报错
        System.out.println(Arrays.toString(nums));

    }


}
