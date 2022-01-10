package com.springboottemplate.leetcode.stackqueue;

import java.util.Stack;

/**
 * @author 唐涛
 * @description: 剑指 Offer 30. 包含min函数的栈
 * @date 2021/12/15 19:57
 * <p>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());


    }


    /**
     * 解题思路，弄一个min stack，也可以叫临时栈
     * 1、 主栈入栈的时候，临时栈也入，但是只入比临时栈栈顶小的数字。
     * 2、 出栈的时候，如果主栈出的值等于临时栈栈顶的值，那么临时栈也出去。这样可以保证，临时栈的栈顶的值，永远是主栈的最小值
     */


    Stack<Integer> stack, temp;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (temp.isEmpty()) {
            temp.push(x);
        } else {
            if (x <= temp.peek()) {//等于的时候也放进去。比如主栈有两个2，临时栈如果只放一个2，那么这个临时栈出了2，最小值不是2了。
                temp.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == temp.peek()) {
            temp.pop();
        }
    }

    /**
     * 实现的方式很多种，比如暴力访问，获取最小值，但是他要求时间复杂度是O1
     *
     * @return
     */
    public int min() {
        return temp.peek();
    }

    public int top() {
        return stack.peek();
    }
}
