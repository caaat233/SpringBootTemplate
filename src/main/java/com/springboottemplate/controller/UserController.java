package com.springboottemplate.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springboottemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 唐涛
 * @description:
 * @date 2021/8/1 19:09
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;


    @SentinelResource("findAllUserFromDB")
    @RequestMapping("findAllUserByDB")
    @ResponseBody
    public List<Map> testfindUser() {
        return userService.findAllUserFromDB();
    }

    @SentinelResource("findOneUserByIdFromDB")
    @RequestMapping("findOneUserByIdFromDB")
    @ResponseBody
    public Map findOneUserByIdFromDB(int id) {
        return userService.findUserByIdFromDB(id);
    }


    @SentinelResource("findUserByNameFromDB")
    @RequestMapping("findUserByNameFromDB")
    @ResponseBody
    public List<Map> findUserByNameFromDB(String name) {
        return userService.findUserByNameFromDB(name);
    }


}
