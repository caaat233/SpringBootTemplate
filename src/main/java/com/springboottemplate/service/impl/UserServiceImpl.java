package com.springboottemplate.service.impl;

import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 唐涛
 * @description: userServiceMysqlImpl
 * @date 2021/8/31 19:09
 */

/**
 * 这个service主要是查询数据库的
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Map> findAllUserFromDB() {
        return userMapper.findAll();
    }


    @Override
    public Map findUserByIdFromDB(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<Map> findUserByNameFromDB(String name) {
        return userMapper.findUserByName(name);
    }

}
