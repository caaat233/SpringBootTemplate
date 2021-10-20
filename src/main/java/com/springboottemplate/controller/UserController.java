package com.springboottemplate.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springboottemplate.pojo.User;
import com.springboottemplate.service.UserService;
import com.springboottemplate.util.UserThreadLocalUtil;
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
        Map userMap = userService.findUserByIdFromDB(id);
        //查询出来的数据放到redis
        String userId = (String) userMap.get("id");
        return userMap;
    }


    @SentinelResource("findUserByNameFromDB")
    @RequestMapping("findUserByNameFromDB")
    @ResponseBody
    public List<Map> findUserByNameFromDB(String name) {
        //使用threadLocal
        User user = new User();
        user.setName("zhangsan");
        //放的时候，可以先remove一下
        UserThreadLocalUtil.rmUserInfo();
        UserThreadLocalUtil.setUserInfo(user);
        return userService.findUserByNameFromDB(name);
    }

    /**
     * 查redis缓存
     *
     * @param id
     * @return
     */
    @SentinelResource("findUserByIdFromRedisA")
    @RequestMapping("findUserByIdFromRedisA")
    @ResponseBody
    public String findUserByIdFromRedisA(int id) {
        return userService.findUserByIdFromRedis(id);
    }

    /**
     * 查redis缓存
     *
     * @param id
     * @return
     */
    @SentinelResource("findUserByIdFromRedisB")
    @RequestMapping("findUserByIdFromRedisB")
    @ResponseBody
    public String findUserByIdFromRedisB(int id) {
        return userService.findUserByIdFromRedis(id);
    }

}
