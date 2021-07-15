package com.springboottemplate.controller;

import com.springboottemplate.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/6/1 16:06
 */
@Controller
@RequestMapping("jvm")
public class JVMController {

    @ResponseBody
    @RequestMapping("oom")
    public void oom() {
        List<User> list = new ArrayList<User>();
        int i = 1;
        while (true) {
            i++;
            list.add(new User());
            if (i%10==0) {
            }
        }
    }

}
