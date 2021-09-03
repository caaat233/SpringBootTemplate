package com.springboottemplate.controller;

import com.springboottemplate.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/6/1 16:06
 */
@Controller
@RequestMapping("jvm")
public class JVMController {

    /***
     * @description: 堆溢出
     * @param
     * @return: void
     */
    @ResponseBody
    @RequestMapping("oom")
    public void oom() {
        List<User> list = new ArrayList<User>();
        int i = 1;
        while (true) {
            i++;
            list.add(new User());
            if (i % 10 == 0) {
            }
        }
    }

    /**
     * 模拟CPU占满
     */
    @ResponseBody
    @RequestMapping("cpu")
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


    /***
     * @description: 递归-栈空间溢出1，
     * @param
     * @return: void
     */
    /**
     * 模拟CPU占满
     */
    @ResponseBody
    @RequestMapping("stack")
    public void stackMemmory1() {

        while (true) {
            stackMemmory1();
        }
    }

}
