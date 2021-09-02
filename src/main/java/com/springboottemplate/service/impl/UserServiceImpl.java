package com.springboottemplate.service.impl;

import com.alibaba.fastjson.JSON;
import com.springboottemplate.constant.RedisPrefixKeyConstants;
import com.springboottemplate.mapper.UserMapper;
import com.springboottemplate.service.UserService;
import org.codehaus.groovy.runtime.dgmimpl.arrays.LongArrayGetAtMetaMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
    @Autowired
    Jedis jedis;


    @Override
    public List<Map> findAllUserFromDB() {
        List<Map> allMap = userMapper.findAll();
        for (Map map : allMap) {
            long id = (long) map.get("id");
            jedis.setex(RedisPrefixKeyConstants.USER_INFO + "_" + id, 300, JSON.toJSONString(map));
        }
        return allMap;
    }


    @Override
    public Map findUserByIdFromDB(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<Map> findUserByNameFromDB(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public String findUserByIdFromRedis(int id) {
        String userInfo = jedis.get(RedisPrefixKeyConstants.USER_INFO + "_" + String.valueOf(id));

        return userInfo;
    }

}