package com.springboottemplate.service.impl;

import com.springboottemplate.controller.UserController;
import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.pojo.User;
import com.springboottemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService2")
public class UserServiceImpl2 implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        System.out.println(UserController.threadLocal.get());
        return null;
    }

    @Override
    public List<Map> findAllDB() {
        return userMapper.findAll();
    }

    @Override
    public Map findOne(int id) {
        return userMapper.findOne(id);
    }
}
