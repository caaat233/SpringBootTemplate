package com.springboottemplate.leetcode.stackqueue;

import java.util.Stack;

/**
 * @author 唐涛
 * @description: 用两个栈实现一个队列思想和java编程实现
 * @date 2021/12/15 19:25
 * https://www.jianshu.com/p/bfc09dc0e02f
 */
public class StackToQueue {
    Stack<Integer> stackA = new Stack<>();//数据c
    Stack<Integer> stackB = new Stack<>();//临时栈

    public static void main(String[] args) {

        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.push(4);
        stackToQueue.pop();
        System.out.println(stackToQueue.toString());

    }


    public void push(int node) {
        stackA.push(node);
    }


    public int pop() {
        //先把A的栈数据都放到B中
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        //将SB的栈顶元素出栈，即出队。
        int first = stackB.pop();
        //如果SB不为空，将SB中的元素出栈，然后入栈到SA中。
        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        //反正是需要 需要来回倒栈
        return first;
    }

    @Override
    public String toString() {
        return "StackToQueue{" +
                "stackA=" + stackA +
                '}';
    }
}
