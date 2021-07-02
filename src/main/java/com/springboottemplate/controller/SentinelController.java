package com.springboottemplate.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springboottemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 唐涛
 * @description: SentinelController
 * @date 2021/5/10 15:49
 */
@RequestMapping("sentinel")
@Controller
public class SentinelController {

    @Autowired
    @Qualifier("userService2")
    //这可以再userService的实现类指定@Primary，如果有多个实现类，默认使用加@Primary注解的实现类
    UserService userService;


    @SentinelResource("hello")
    @RequestMapping("hello")
    @ResponseBody
    public String testhello() {
        return "Hello,Sentinel";
    }

    @SentinelResource("finduser")
    @RequestMapping("finduser")
    @ResponseBody
    public List<Map> testfindUser() {
        return userService.findAllDB();
    }

}
