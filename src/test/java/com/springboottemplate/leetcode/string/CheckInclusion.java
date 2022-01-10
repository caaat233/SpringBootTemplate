package com.springboottemplate.leetcode.string;

import java.util.LinkedList;

/**
 * @author 唐涛
 * @description: 567. 字符串的排列
 * @date 2021/12/13 15:51
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 子串的概念：串中任意个连续字符组成的子序列称为该串的子串。比如abc  可以有：abc ,cba ,acb ,bac.字串的个数不会缺失
 * <p>
 * todo 我根本不会做
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {

        return true;
    }


    public boolean 自己的解法() {

        String s1 = "abc";
        String s2 = "eidbaooo";
        int s1Int = 0;
        //我们通过计算s1对应的int值是多少，如果int值跟s2字串的int值相等。说明在。
        for (int i = 0; i < s1.length(); i++) {
            s1Int += (int) s1.charAt(i);
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < s2.length(); i++) {
            new StringBuilder().append("c").toString().toCharArray();
        }


        return true;
    }

}
/**
 * @Darcy 这个题可以理解为在二维数组中，我们先指定其中一个元素A，我们希望把这个元素A的值改成我们新传入的值，
 * <p>
 * 同时，与元素A在上下左右四个方向相邻的元素，如果他们的值与元素A的值相同，那么他们也会被修改为新的值
 * <p>
 * A在上下左右四个方向相邻的元素中，与元素A的值相同的元素 的 上下左右四个方向相邻的元素 如果值与元素A的值相同，也会被渲染
 * <p>
 * 通俗一点就是，你在二维数组中通过上下左右四个方向移动找出所有路径，这些路径上的值都是元素A，然后把这些路径上的值都改成我们传入的新的值
 * <p>
 * class Solution {
 * boolean visited[][];
 * public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
 * int oldColor=image[sr][sc];
 * visited=new boolean[image.length][image[0].length];
 * dfs(image,sr, sc,  newColor,oldColor);
 * return image;
 * }
 * public void dfs(int[][] image, int sr, int sc, int newColor,int oldColor){
 * if( sr<0||sr>image.length-1||sc<0||sc>image[0].length-1)
 * return;
 * if(image[sr][sc]==oldColor&&!visited[sr][sc]){
 * image[sr][sc]=newColor;
 * visited[sr][sc]=true;//记录访问过的位置，防止重复访问造成无法退出循环
 * }
 * else
 * return ;
 * dfs(image,sr+1, sc,  newColor,oldColor) ;//向下
 * dfs(image,sr-1, sc,  newColor,oldColor) ;//向上
 * dfs(image,sr, sc+1,  newColor,oldColor) ;//向左
 * dfs(image,sr, sc-1,  newColor,oldColor) ;//向右
 * }
 * }
 */

