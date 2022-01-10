package com.springboottemplate.java8;

import java.util.Stack;

/**
 * @author 唐涛
 * @description: https://www.cnblogs.com/whsa/p/4272717.html
 * @date 2021/12/15 19:15
 */
public class StackTest {
    /**
     * 方法摘要
     * boolean	empty() 测试堆栈是否为空。
     * E	peek()  查看堆栈顶部的对象，但不从堆栈中移除它。
     * E	pop()  移除堆栈顶部的对象，并作为此函数的值返回该对象。
     * E	push(E item) 把项压入堆栈顶部。
     * int	search(Object o)
     * 返回对象在堆栈中的位置，以 1 为基数。
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println("now the satck is " + isEmpty(stack));
        stack.push("1");
        stack.push("2");
        stack.push("3");//加入元素
        stack.push("4");
        stack.push("5");
        stack.push("6");
        System.out.println("now the stack is " + isEmpty(stack));
        System.out.println(stack.peek());//查看堆栈顶部的对象，并返回该对象，但不从堆栈中移除它。
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.search("3"));//，此方法返回最近的目标对象距堆栈顶部出现位置到堆栈顶部的距离；

    }

    public static String isEmpty(Stack<String> stack) {
        return stack.empty() ? "empty" : "not empty";
    }
}