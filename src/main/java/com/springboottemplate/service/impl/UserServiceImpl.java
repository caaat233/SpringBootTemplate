package com.springboottemplate.service.impl;

import java.util.List;
import java.util.Map;

import com.springboottemplate.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.pojo.User;
import com.springboottemplate.service.UserService;

@Service("userService1")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        System.out.println(UserController.threadLocal.get());
        return null;
    }

    @Override
    public List<Map>  findAllDB() {
        return userMapper.findAll();
    }


}
