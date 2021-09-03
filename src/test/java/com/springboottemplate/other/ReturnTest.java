package com.springboottemplate.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReturnTest {

    @Test
    public void TestReturn() {
        return1();

        System.out.println("11111111111111");

    }

    public int return1() {
        return 1;

    }

    /***
     * @description: 递归-栈空间溢出1，
     * @param
     * @return: void
     */

    @Test
    public void stackMemmory1() {

        while (true) {
            stackMemmory1();
        }
    }

    /***
     * @description: 堆溢出
     * @param
     * @return: void
     */

    @Test
    public void heapMemmory() {

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new String(i + ""));
            i++;
        }
    }


    /**
     * 模拟CPU占满
     */
    @Test
    public void testCPULoop() throws InterruptedException {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }

}
